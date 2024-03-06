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

import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.dto.UserDTO;
import io.xianzhi.system.service.UserService;
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


}
