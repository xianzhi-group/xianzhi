/*
 * Copyright (c) 2023-2023  XianZhi Group (team@xianzhi.io) All Rights
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

package io.xianzhi.core.code;

import io.xianzhi.core.result.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公共响应状态码<br>
 *
 * @author Max
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum CommonCode implements Result {
    /**
     * 操作成功
     */
    SUCCESS("200", true, "success"),
    /**
     * 操作失败
     */
    FAIL("500", false, "fail"),
    /**
     * 系统错误
     */
    ERROR("-1", false, "error"),

    /**
     * 未登录
     */
    UNAUTHORIZED("401", false, "unauthorized"),
    /**
     * 没有操作权限
     */
    FORBIDDEN("403", false, "forbidden"),
    /**
     * 请求方式错误
     */
    METHOD_NOT_SUPPORT("405", false, "method.not.support"),
    /**
     * 请求参数错误
     */
    REQUEST_PARAMS_ERROR("400", false, "request.params.error"),
    /**
     * 验证错误
     */
    CAPTCHA_ERROR("XZ-00-00000", false, "captcha.error"),
    /**
     * 手机号码格式错误
     */
    PHONE_FORMAT_ERROR("XZ-00-00001", false, "phone.format.error"),
    /**
     * 邮箱格式错误
     */
    EMAIL_FORMAT_ERROR("XZ-00-00002", false, "email.format.error"),
    /**
     * 对象类型错误
     */
    OBJECT_TYPE_ERROR("XZ-00-00003", false, "object.type.error"),
    /**
     * 参数检查失败
     */
    PARAMS_CHECKED_ERROR("XZ-00-00004", false, "params.checked.error"),
    ;

    /**
     * 自定义状态码
     */
    private final String code;
    /**
     * 是否成功
     */
    private final boolean success;
    /**
     * 提示信息
     */
    private final String message;


    /**
     * 自定义状态码
     *
     * @return 自定义状态码
     */
    @Override
    public String code() {
        return this.code;
    }

    /**
     * 是否操作成功
     *
     * @return 是否操作成功
     */
    @Override
    public boolean success() {
        return this.success;
    }

    /**
     * 自定义提示信息
     *
     * @return 自定义提示信息
     */
    @Override
    public String message() {
        return this.message;
    }

}
