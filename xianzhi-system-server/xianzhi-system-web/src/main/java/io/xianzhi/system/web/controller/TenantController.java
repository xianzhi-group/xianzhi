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
import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.page.TenantPage;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 租户管理接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tenant")
public class TenantController {
    /**
     * 租户服务
     */
    private final TenantService tenantService;

    /**
     * 创建租户<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    @PostMapping(value = "/createTenant")
    public ResponseResult<String> createTenant(@RequestBody @Validated TenantDTO tenantDTO) {
        return ResponseResult.ok(tenantService.createTenant(tenantDTO));
    }

    /**
     * 修改租户信息<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 响应信息
     */
    @PostMapping(value = "/updateTenant")
    public ResponseResult<Object> updateTenant(@RequestBody @Validated TenantDTO tenantDTO) {
        tenantService.updateTenant(tenantDTO);
        return ResponseResult.ok();
    }

    /**
     * 删除租户<br>
     *
     * @param id 租户ID
     * @return 响应信息
     */
    @PostMapping(value = "/deleted/{id}")
    public ResponseResult<Object> deleteTenant(@PathVariable(value = "id") String id) {
        tenantService.deleteTenant(id);
        return ResponseResult.ok();
    }

    /**
     * 查询租户详情
     *
     * @param id 租户ID
     * @return 租户详情
     */
    @GetMapping(value = "/details/{id}")
    public ResponseResult<TenantVO> details(@PathVariable(value = "id") String id) {
        return ResponseResult.ok(tenantService.details(id));
    }

    /**
     * 启用租户 <br>
     *
     * @param id 租户ID
     * @return 响应信息
     */
    @PostMapping(value = "/enable/{id}")
    public ResponseResult<Object> enable(@PathVariable(value = "id") String id) {
        return ResponseResult.ok();
    }

    /**
     * 禁用租户 <br>
     *
     * @param id 租户ID
     * @return 响应信息
     */
    @PostMapping(value = "/disable/{id}")
    public ResponseResult<Object> disable(@PathVariable(value = "id") String id) {
        return ResponseResult.ok();
    }

    /**
     * 查询租户列表
     *
     * @param tenantPage 租户查询条件
     * @return 租户列表
     */
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<TenantVO>> list(@RequestBody TenantPage tenantPage) {
        return ResponseResult.ok();
    }

}
