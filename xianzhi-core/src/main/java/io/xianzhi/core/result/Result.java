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

package io.xianzhi.core.result;

/**
 * 响应结果<br>
 *
 * @author Max
 * @since 1.0.0
 */
public interface Result {

    /**
     * 返回自定义状态码
     *
     * @return 自定义状态码
     */
    String code();

    /**
     * 返回是否操作成功
     *
     * @return 是否操作成功
     */
    boolean success();

    /**
     * 返回自定义提示信息
     *
     * @return 自定义提示信息
     */
    String message();
}

