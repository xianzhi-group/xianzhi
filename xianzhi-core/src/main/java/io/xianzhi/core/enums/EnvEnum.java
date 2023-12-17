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

package io.xianzhi.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 环境枚举<br>
 *
 * @author Max
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum EnvEnum {

    /**
     * 线下/开发环境
     */
    DEV("dev", "线下/开发环境"),
    /**
     * 测试环境
     */
    TEST("test", "测试环境"),
    /**
     * 交付环境
     */
    UAT("uat", "交付环境"),
    /**
     * 预发环境
     */
    PRE("pre", "预发环境"),
    /**
     * 灰度环境
     */
    GRAY("gray", "灰度环境"),
    /**
     * 生产环境
     */
    PROD("prod", "生产环境"),
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
