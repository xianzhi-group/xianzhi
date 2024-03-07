/*
 * Copyright (c) 2023-2024  XianZhi Group All Rights
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.xianzhi.authorization.oauth2.handlers;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.xianzhi.authorization.constants.OAuth2Constant;
import io.xianzhi.authorization.dao.dataobj.OAuth2ClientDO;
import io.xianzhi.authorization.dao.mapper.OAuth2ClientMapper;
import io.xianzhi.authorization.enums.GrantTypeEnum;
import io.xianzhi.authorization.oauth2.XianZhiOAuth2UserDetails;
import io.xianzhi.authorization.properties.OAuth2Properties;
import io.xianzhi.boot.oauth2.resource.code.OAuth2Code;
import io.xianzhi.boot.redis.RedisHandler;
import io.xianzhi.boot.security.constants.SecurityConstant;
import io.xianzhi.boot.security.properties.SecurityProperties;
import io.xianzhi.common.context.UserContext;
import io.xianzhi.common.exception.BizException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Redis客户端信息<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class XianZhiRedisRegisteredClientRepository implements RegisteredClientRepository, InitializingBean {
    /**
     * 客户端信息持久层
     */
    private final OAuth2ClientMapper oAuth2ClientMapper;
    /**
     * 缓存处理
     */
    private final RedisHandler redisHandler;
    /**
     * oauth2配置
     */
    private final OAuth2Properties oAuth2Properties;
    /**
     * 安全配置
     */
    private final SecurityProperties securityProperties;

    /**
     * Saves the registered client.
     *
     * <p>
     * IMPORTANT: Sensitive information should be encoded externally from the implementation, e.g. {@link RegisteredClient#getClientSecret()}
     *
     * @param registeredClient the {@link RegisteredClient}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(RegisteredClient registeredClient) {
        if (null == registeredClient) {
            log.error("保存客户端信息失败，客户端信息为空");
            throw new BizException(OAuth2Code.CLIENT_ERROR);
        }
        if (StringUtils.hasText(registeredClient.getId()) && !registeredClient.getId().contains("-")) {
            update(registeredClient);
        } else {
            insert(registeredClient);
        }
    }

    /**
     * Returns the registered client identified by the provided {@code id},
     * or {@code null} if not found.
     *
     * @param id the registration identifier
     * @return the {@link RegisteredClient} if found, otherwise {@code null}
     */
    @Override
    public RegisteredClient findById(String id) {
        if (StringUtils.hasText(id)) {
            OAuth2ClientDO clientDO = redisHandler.valueGet(OAuth2Constant.CACHE_OAUTH_CLIENT_ID + id, OAuth2ClientDO.class);
            if (null == clientDO) {
                clientDO = oAuth2ClientMapper.queryById(id);
                if (null == clientDO) {
                    log.error("客户端信息不存在，客户端主键ID:{}", id);
                    throw new BizException(OAuth2Code.CLIENT_ERROR);
                }
                redisHandler.valueSet(OAuth2Constant.CACHE_OAUTH_CLIENT_ID + id, clientDO);
            }
            return clientDOToRegisterClient(clientDO);
        }
        return null;
    }

    /**
     * Returns the registered client identified by the provided {@code clientId},
     * or {@code null} if not found.
     *
     * @param clientId the client identifier
     * @return the {@link RegisteredClient} if found, otherwise {@code null}
     */
    @Override
    public RegisteredClient findByClientId(String clientId) {
        if (StringUtils.hasText(clientId)) {
            OAuth2ClientDO clientDO = redisHandler.valueGet(OAuth2Constant.CACHE_OAUTH_CLIENT_CLIENT_ID + clientId, OAuth2ClientDO.class);
            if (null == clientDO) {
                clientDO = oAuth2ClientMapper.queryByClientId(clientId);
                if (null == clientDO) {
                    log.error("客户端信息不存在，客户端ID:{}", clientId);
                    throw new BizException(OAuth2Code.CLIENT_ERROR);
                }
                redisHandler.valueSet(OAuth2Constant.CACHE_OAUTH_CLIENT_CLIENT_ID + clientId, clientDO);
            }
            return clientDOToRegisterClient(clientDO);
        }
        return null;
    }

    /**
     * 新增客户端信息
     *
     * @param registeredClient 客户端信息
     */
    private void insert(RegisteredClient registeredClient) {
        // 判断客户端ID是否存在
        if (oAuth2ClientMapper.existsClientByIdAndIdNot(registeredClient.getClientId(), null)) {
            throw new RuntimeException("clientId已经存在");
        }
        // 判断客户端名称是否存在
        if (oAuth2ClientMapper.existsClientByNameAndIdNot(registeredClient.getClientName(), null)) {
            throw new RuntimeException("clientName已经存在");
        }
        OAuth2ClientDO OAuth2ClientDO = registeredClientToOAuth2ClientDO(registeredClient);
        oAuth2ClientMapper.insert(OAuth2ClientDO);

    }

    private void update(RegisteredClient registeredClient) {

    }


    private RegisteredClient clientDOToRegisterClient(OAuth2ClientDO entity) {
        RegisteredClient.Builder builder = RegisteredClient.withId(entity.getId())
                .clientId(entity.getClientId())
                .clientSecret(SecurityConstant.NOOP + entity.getClientSecret())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC);
        String authorizationGrantTypes = entity.getAuthorizationGrantTypes();
        List<AuthorizationGrantType> authorizationGrantTypeList = JSON.parseArray(authorizationGrantTypes, AuthorizationGrantType.class);
        for (AuthorizationGrantType authorizedGrantType : authorizationGrantTypeList) {
            builder.authorizationGrantType(authorizedGrantType);
        }
        // 回调地址
        Optional.ofNullable(entity.getRedirectUris())
                .ifPresent(redirectUri -> JSON.parseArray(entity.getRedirectUris(), String.class).stream()
                        .filter(StrUtil::isNotBlank)
                        .forEach(builder::redirectUri));

        // scope
        Optional.ofNullable(entity.getScopes())
                .ifPresent(scope -> JSON.parseArray(scope, String.class).stream()
                        .filter(StrUtil::isNotBlank)
                        .forEach(builder::scope));

        // postLogoutRedirectUris
        Optional.ofNullable(entity.getPostLogoutRedirectUris())
                .ifPresent(postRedirectUri -> JSON.parseArray(entity.getPostLogoutRedirectUris(), String.class).stream()
                        .filter(StrUtil::isNotBlank)
                        .forEach(builder::postLogoutRedirectUri));
        JSONObject tokenSettings = JSON.parseObject(entity.getTokenSettings(), JSONObject.class);
        JSONObject clientSettings = JSON.parseObject(entity.getClientSettings(), JSONObject.class);

        return builder
                .tokenSettings(TokenSettings.builder()
                        .accessTokenTimeToLive(Duration.parse(tokenSettings.getString("accessTokenTimeToLive")))
                        .accessTokenFormat(OAuth2TokenFormat.REFERENCE)
                        .refreshTokenTimeToLive(Duration.parse(tokenSettings.getString("refreshTokenTimeToLive")))
                        .idTokenSignatureAlgorithm(SignatureAlgorithm.RS256)
                        .reuseRefreshTokens(true).build())
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(clientSettings.getBoolean("requireAuthorizationConsent"))
                        .requireProofKey(clientSettings.getBoolean("requireProofKey")).build()).build();
    }


    public OAuth2ClientDO registeredClientToOAuth2ClientDO(RegisteredClient registeredClient) {
        OAuth2ClientDO entity = new OAuth2ClientDO();
        entity.setClientId(registeredClient.getClientId());
        entity.setClientSecret(registeredClient.getClientSecret());
        entity.setClientName(registeredClient.getClientName());
        entity.setClientSettings(JSON.toJSONString(registeredClient.getClientSettings()));
        entity.setClientAuthenticationMethods(JSON.toJSONString(registeredClient.getClientAuthenticationMethods()));
        if (null == registeredClient.getClientIdIssuedAt()) {
            entity.setClientIdIssuedAt(new Date());

        } else {
            entity.setClientIdIssuedAt(Date.from(registeredClient.getClientIdIssuedAt()));
        }

        if (null != registeredClient.getClientSecretExpiresAt()) {
            entity.setClientSecretExpiresAt(Date.from(registeredClient.getClientSecretExpiresAt()));
        }
        entity.setScopes(JSON.toJSONString(registeredClient.getScopes()));
        entity.setRedirectUris(JSON.toJSONString(registeredClient.getRedirectUris()));
        entity.setTokenSettings(JSON.toJSONString(registeredClient.getTokenSettings()));
        entity.setAuthorizationGrantTypes(JSON.toJSONString(registeredClient.getAuthorizationGrantTypes()));
        entity.setPostLogoutRedirectUris(JSON.toJSONString(registeredClient.getPostLogoutRedirectUris()));
        return entity;
    }


    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        XianZhiOAuth2UserDetails userBO = new XianZhiOAuth2UserDetails();
        userBO.setId("00001");
        UserContext.set(userBO);
        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("xianzhi")
                .clientName("xianzhi")
                .clientSecret("xianzhi")
                .tokenSettings(TokenSettings
                        .builder()
                        .accessTokenFormat(OAuth2TokenFormat.REFERENCE)
                        .accessTokenTimeToLive(Duration.ofDays(2000))
                        .refreshTokenTimeToLive(Duration.ofDays(2000))
                        .build())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(new AuthorizationGrantType(GrantTypeEnum.PASSWORD.getCode()))
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .scope("server")
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(false).build())
                .build();
//        save(registeredClient);
    }
}