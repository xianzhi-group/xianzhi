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
 * 字典枚举<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum DictEnum {
    /**
     * 所属行业
     */
    INDUSTRY("SYS_INDUSTRY", "所属行业"),
    /**
     * 公司规模
     */
    SCALE("SYS_SCALE", "公司规模"),

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
