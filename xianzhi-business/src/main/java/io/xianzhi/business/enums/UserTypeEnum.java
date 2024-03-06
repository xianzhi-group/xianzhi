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

package io.xianzhi.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型枚举<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    /**
     * 系统用户
     */
    SYSTEM("SYSTEM", "系统用户"),
    /**
     * 普通用户
     */
    PERSON("PERSON", "普通用户"),
    /**
     * 企业用户
     */
    ENTERPRISE("ENTERPRISE", "企业用户"),

    ;

    /**
     * 用户类型code
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;
}
