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

package io.xianzhi.business.utils;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * web工具类<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public class WebUtil {

    public static final String TENANT_ID = "X-Tenant-Id";

    /**
     * 获取Request对象
     *
     * @return Request对象
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }


    /**
     * 获取当前租户ID
     *
     * @return 租户ID
     */
    public static String getCurrentTenantId() {
        return WebUtil.getRequest().getHeader(TENANT_ID);
    }
}
