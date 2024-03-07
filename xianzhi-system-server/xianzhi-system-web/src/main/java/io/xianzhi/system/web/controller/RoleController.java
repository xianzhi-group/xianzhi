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
import io.xianzhi.system.model.dto.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 角色接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/role")
public class RoleController {

    /**
     * 新增角色
     *
     * @param roleDTO 角色信息入参
     * @return 角色id
     */
    @PostMapping(value = "/createRole")
    public ResponseResult<String> createRole(@RequestBody @Validated RoleDTO roleDTO) {
        return ResponseResult.ok();
    }

    /**
     * 更新角色
     *
     * @param roleDTO 角色信息入参
     * @return 响应信息
     */
    @PostMapping(value = "/updateRole")
    public ResponseResult<Object> updateRole(@RequestBody @Validated RoleDTO roleDTO) {
        return ResponseResult.ok();
    }

    /**
     * 删除角色
     *
     * @param id 角色id
     * @return 响应信息
     */
    @PostMapping(value = "/deleted/{id}")
    public ResponseResult<Object> deleteRole(@PathVariable(value = "id") String id) {
        return ResponseResult.ok();
    }

}
