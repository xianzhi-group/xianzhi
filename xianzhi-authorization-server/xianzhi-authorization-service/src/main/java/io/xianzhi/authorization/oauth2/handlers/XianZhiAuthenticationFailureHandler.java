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

import io.xianzhi.boot.oauth2.resource.exception.OAuth2Exception;
import io.xianzhi.boot.security.utils.ResponseUtil;
import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.result.ResponseResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 认证失败处理<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component(value = "xianZhiAuthenticationFailureHandler")
public class XianZhiAuthenticationFailureHandler implements AuthenticationFailureHandler {


    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     *                  request.
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.error("认证失败处理", exception);
        if (exception instanceof OAuth2AuthenticationException) {
            if (exception instanceof OAuth2Exception) {
                ResponseUtil.responseUtf8(ResponseResult.fail(((OAuth2Exception) exception).getResult()), response);
                return;
            }
        }
        ResponseUtil.responseUtf8(ResponseResult.fail(CommonCode.ERROR), response);

    }
}