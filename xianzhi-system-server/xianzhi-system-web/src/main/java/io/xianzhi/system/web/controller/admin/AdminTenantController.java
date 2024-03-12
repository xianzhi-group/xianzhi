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
import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.page.TenantPage;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.service.admin.AdminTenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 租户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mng/tenant")
public class AdminTenantController {

    /**
     * 管理员租户接口
     */
    private final AdminTenantService adminTenantService;

    /**
     * 查询租户列表
     *
     * @param tenantPage 租户查询条件
     * @return 租户列表
     */
    @PreAuthorize("@xz.hasPermission('admin:tenant:list','admin:tenant:create','admin:tenant:update','admin:tenant:deleted')")
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<TenantVO>> list(@RequestBody @Validated TenantPage tenantPage) {
        return ResponseResult.ok(adminTenantService.list(tenantPage));
    }

    /**
     * 新增一个租户
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    @PreAuthorize("@xz.hasPermission('admin:tenant:create')")
    @PostMapping(value = "/create")
    public ResponseResult<String> create(@RequestBody @Validated TenantDTO tenantDTO) {
        return ResponseResult.ok();
    }

    /**
     * 修改一个租户
     *
     * @param tenantDTO 租户信息入参
     * @return 响应信息
     */
    @PreAuthorize("@xz.hasPermission('admin:tenant:update')")
    @PostMapping(value = "/update")
    public ResponseResult<Object> update(@RequestBody @Validated TenantDTO tenantDTO) {
        return ResponseResult.ok();
    }

    /**
     * 查询租户详情
     *
     * @param tenantId 租户ID
     * @return 租户详情
     */
    @PreAuthorize("@xz.hasPermission('admin:tenant:details')")
    @PostMapping(value = "/details/{tenantId}")
    public ResponseResult<TenantVO> details(@PathVariable(value = "tenantId") String tenantId) {
        return ResponseResult.ok();
    }


    /**
     * 删除租户<br>
     *
     * @param id 租户ID
     * @return 响应信息
     */
    @PreAuthorize("@xz.hasPermission('admin:tenant:deleted')")
    @PostMapping(value = "/deleted/{id}")
    public ResponseResult<Object> deleteTenant(@PathVariable(value = "id") String id) {
        return ResponseResult.ok();
    }
}
