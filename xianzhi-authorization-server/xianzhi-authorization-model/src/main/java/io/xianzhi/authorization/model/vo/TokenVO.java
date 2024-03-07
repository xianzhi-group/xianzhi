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

package io.xianzhi.authorization.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * token信息出参<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Data
public class TokenVO implements Serializable {
    /**
     * 用户ID
     */
    private String id;
    /**
     * 姓名
     */
    private String fullName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;
    /**
     * 认证token
     */
    private String accessToken;

    /**
     * 刷新token
     */
    private String refreshToken;
}

