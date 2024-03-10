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

package io.xianzhi.system.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 资源信息出参<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Data
public class ResourceVO implements Serializable {
    /**
     * 资源ID
     */
    private String id;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 资源标识符
     */
    private String resourceKey;
}
