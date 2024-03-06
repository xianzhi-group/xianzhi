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

package io.xianzhi.system.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 租户状态枚举<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum TenantStatusEnum {

    /**
     * 禁用
     */
    DISABLE("DISABLE", "禁用"),
    /**
     * 正常
     */
    NORMAL("NORMAL", "正常"),
    /**
     * 未认证
     */
    NOT_CERTIFIED("NOT_CERTIFIED", "未认证"),

    ;
    /**
     * code
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;
}
