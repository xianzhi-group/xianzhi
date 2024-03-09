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
import java.util.List;

/**
 * 认证用户信息出参<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Data
public class AuthUserVO implements Serializable {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobileNumber;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 工号仅系统用户有
     */
    private String workNumber;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 用户类型
     */
    private String userType;
    /**
     * 系统角色
     */
    private List<RoleVO> roles;
    /**
     * 用户状态
     */
    private String status;
    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 是否启用
     */
    private Boolean enable;
}
