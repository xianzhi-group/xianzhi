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

package io.xianzhi.system.web.controller;

import io.xianzhi.common.result.ListResult;
import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.dto.UserDTO;
import io.xianzhi.system.model.page.UserPage;
import io.xianzhi.system.model.vo.UserVO;
import io.xianzhi.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 用户服务
     */
    private final UserService userService;

    /**
     * 新增用户
     *
     * @param userDTO 用户信息入参
     * @return 响应信息
     */
    @PostMapping(value = "/createUser")
    public ResponseResult<String> createUser(@RequestBody @Validated UserDTO userDTO) {
        return ResponseResult.ok(userService.createUser(userDTO));
    }

    /**
     * 更新用户
     *
     * @param userDTO 用户信息入参
     * @return 响应信息
     */
    @PostMapping(value = "/updateUser")
    public ResponseResult<Object> updateUser(@RequestBody @Validated UserDTO userDTO) {
        return ResponseResult.ok();
    }

    /**
     * 查询用户详情
     *
     * @param id 用户ID
     * @return 用户详情
     */
    @GetMapping(value = "/details/{id}")
    public ResponseResult<UserVO> details(@PathVariable(value = "id") String id) {
        return ResponseResult.ok();
    }

    /**
     * 查询用户列表
     *
     * @param userPage 用户查询条件
     * @return 用户列表
     */
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<UserVO>> list(UserPage userPage) {
        return ResponseResult.ok();
    }


}
