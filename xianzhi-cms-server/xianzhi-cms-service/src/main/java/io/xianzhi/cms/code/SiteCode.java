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

package io.xianzhi.cms.code;

import io.xianzhi.common.result.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 站点Code<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum SiteCode implements Result {
    /**
     * 默认站点已经存在
     */
    DEFAULT_SITE_EXISTS("CMS-SITE-001", false, "default.site.exists"),
    /**
     * 站点不存在
     */
    SITE_NOT_EXISTS("CMS-SITE-002", false, "site.not.exists"),
    /**
     * 默认站点不支持删除
     */
    DEFAULT_SITE_NOT_SUPPORT_DELETED("CMS-SITE-003", false, "default.site.not.support.deleted"),
    ;


    /**
     * custom response status code
     */
    private final String code;
    /**
     * whether the operation was successful or not
     */
    private final boolean success;
    /**
     * custom prompt information
     */
    private final String message;


    /**
     * This method returns custom response status codes,
     * non HTTP status codes, or other response status codes
     *
     * @return custom response status code
     */
    @Override
    public String code() {
        return this.code;
    }

    /**
     * This method returns whether the operation was successful or not
     *
     * @return whether the operation was successful or not
     */
    @Override
    public boolean success() {
        return this.success;
    }

    /**
     * This method returns custom prompt information
     *
     * @return custom prompt information
     */
    @Override
    public String message() {
        return this.message;
    }
}
