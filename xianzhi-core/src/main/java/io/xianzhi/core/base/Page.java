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

package io.xianzhi.core.base;

import lombok.Data;

/**
 * 基础分页查询条件<br>
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class Page {

    /**
     * 当前页码
     */
    private Integer pageNo;

    /**
     * 每页展示条数
     */
    private Integer pageSize;
}
