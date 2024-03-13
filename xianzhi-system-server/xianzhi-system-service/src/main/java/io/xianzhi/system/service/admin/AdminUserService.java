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

package io.xianzhi.system.service.admin;

import io.xianzhi.common.result.ListResult;
import io.xianzhi.system.model.dto.UserDTO;
import io.xianzhi.system.model.page.UserPage;
import io.xianzhi.system.model.vo.UserVO;

import java.util.List;

/**
 * 管理员用户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public interface AdminUserService {

    /**
     * 用户列表
     *
     * @param userPage 用户查询条件
     * @return 用户列表
     */
    ListResult<UserVO> list(UserPage userPage);


    /**
     * 新增一个用户
     *
     * @param userDTO 用户信息入参
     * @return 响应信息
     */
    String crateUser(UserDTO userDTO);


    /**
     * 搜索系统用户列表
     *
     * @param key 关键字，昵称，真实姓名，工号
     * @return 用户信息
     */
    List<UserVO> search(String key);


}