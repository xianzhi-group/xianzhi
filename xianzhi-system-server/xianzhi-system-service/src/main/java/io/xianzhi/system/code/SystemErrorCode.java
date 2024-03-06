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

package io.xianzhi.system.code;

import io.xianzhi.common.result.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统服务错误码<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum SystemErrorCode implements Result {
    /**
     * 租户不存在
     */
    TENANT_NOT_EXISTS("10001", false, "tenant.not.exist"),
    /**
     * 租户名称已存在
     */
    TENANT_NAME_EXISTS("10002", false, "tenant.name.exists"),
    /**
     * 租户编码已存在
     */
    TENANT_CODE_EXISTS("10003", false, "tenant.code.exists"),
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
