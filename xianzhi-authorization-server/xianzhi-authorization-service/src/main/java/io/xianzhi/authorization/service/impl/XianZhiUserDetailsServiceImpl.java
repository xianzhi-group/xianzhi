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

package io.xianzhi.authorization.service.impl;

import com.alibaba.fastjson2.JSON;
import io.xianzhi.authorization.enums.GrantTypeEnum;
import io.xianzhi.authorization.oauth2.XianZhiOAuth2UserDetails;
import io.xianzhi.authorization.service.XianZhiUserDetailsService;
import io.xianzhi.boot.oauth2.resource.exception.OAuth2Exception;
import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.facade.UserFacade;
import io.xianzhi.system.model.vo.AuthUserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 用户认证信息接口实现<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class XianZhiUserDetailsServiceImpl implements XianZhiUserDetailsService {

    /**
     * 用户服务
     */
    @DubboReference
    private UserFacade userFacade;

    /**
     * 判断是否支持
     *
     * @param grantType 授权类型
     * @return 是否支持
     */
    @Override
    public boolean support(String grantType) {
        return GrantTypeEnum.PASSWORD.getCode().equals(grantType);
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasText(username)) {
            log.error("用户名不能为空");
            throw new UsernameNotFoundException(CommonCode.PARAMETER_CHECK_FAILED.getMessage());
        }
        ResponseResult<AuthUserVO> result = userFacade.loadAuthUserByUsernameAndUserType(username, "");
        if (!result.isSuccess() || null == result.getData()) {
            log.error("请求查询用户认证信息失败:{}", JSON.toJSONString(result));
            throw new OAuth2Exception(result);
        }
        AuthUserVO data = result.getData();
        XianZhiOAuth2UserDetails userDetails = new XianZhiOAuth2UserDetails();

        return userDetails;
    }
}
