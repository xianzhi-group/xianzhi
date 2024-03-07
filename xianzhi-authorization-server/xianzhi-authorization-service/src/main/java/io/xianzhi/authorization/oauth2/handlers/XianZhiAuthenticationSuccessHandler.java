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

import com.alibaba.fastjson2.JSON;
import io.xianzhi.authorization.model.vo.TokenVO;
import io.xianzhi.boot.security.utils.ResponseUtil;
import io.xianzhi.common.result.ResponseResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * r认证成功处理<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component
public class XianZhiAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     *                       the authentication process.
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("认证成功处理:{}", JSON.toJSONString(authentication));
        OAuth2AccessTokenAuthenticationToken auth2AccessTokenAuthenticationToken = (OAuth2AccessTokenAuthenticationToken) authentication;
        OAuth2AccessToken accessToken = auth2AccessTokenAuthenticationToken.getAccessToken();
        OAuth2RefreshToken refreshToken = auth2AccessTokenAuthenticationToken.getRefreshToken();
        TokenVO tokenVO = getTokenVO(auth2AccessTokenAuthenticationToken, accessToken, refreshToken);
        ResponseUtil.responseUtf8(ResponseResult.ok(tokenVO), response);
    }

    private static TokenVO getTokenVO(OAuth2AccessTokenAuthenticationToken auth2AccessTokenAuthenticationToken, OAuth2AccessToken accessToken, OAuth2RefreshToken refreshToken) {
        Map<String, Object> additionalParameters = auth2AccessTokenAuthenticationToken.getAdditionalParameters();
        TokenVO tokenVO = new TokenVO();
        tokenVO.setId((String) additionalParameters.get("id"));
        tokenVO.setAvatar((String) additionalParameters.get("avatar"));
        tokenVO.setNickName((String) additionalParameters.get("nickName"));
        tokenVO.setAccessToken(accessToken.getTokenValue());
        if (null != refreshToken) {
            tokenVO.setRefreshToken(refreshToken.getTokenValue());
        }
        return tokenVO;
    }


}
