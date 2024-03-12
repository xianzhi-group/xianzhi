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

package io.xianzhi.system.web.controller.admin;

import io.xianzhi.common.result.ListResult;
import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.dto.UserDTO;
import io.xianzhi.system.model.page.UserPage;
import io.xianzhi.system.model.vo.UserVO;
import io.xianzhi.system.service.admin.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mng/user")
public class AdminUserController {

    /**
     * 管理员用户接口
     */
    private final AdminUserService adminUserService;


    /**
     * 查询所有用户列表
     *
     * @param userPage 用户查询条件
     * @return 用户列表
     */
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<UserVO>> list(@RequestBody @Validated UserPage userPage) {
        return ResponseResult.ok();
    }

    /**
     * 新增用户
     *
     * @param userDTO 用户信息入参
     * @return 用户ID
     */
    @PostMapping(value = "/create")
    public ResponseResult<String> create(@RequestBody @Validated UserDTO userDTO) {
        return ResponseResult.ok();
    }

    /**
     * 修噶用户
     *
     * @param userDTO 用户信息入参
     * @return 响应信息
     */
    @PostMapping(value = "/update")
    public ResponseResult<Object> update(@RequestBody @Validated UserDTO userDTO) {
        return ResponseResult.ok();
    }

}
