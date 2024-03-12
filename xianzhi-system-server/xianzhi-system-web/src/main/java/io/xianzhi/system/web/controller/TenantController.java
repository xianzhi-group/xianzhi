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

import io.xianzhi.business.annotations.UserTypeCheck;
import io.xianzhi.business.enums.UserTypeEnum;
import io.xianzhi.common.result.ListResult;
import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.page.TenantPage;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 查询当前用户所具有的租户信息
     *
     * @return 当前用户所具有的租户信息
     */
    @GetMapping(value = "/me")
    @UserTypeCheck(usertype = UserTypeEnum.ENTERPRISE)
    public ResponseResult<List<TenantVO>> me() {
        return ResponseResult.ok(tenantService.me());
    }

    /**
     * 创建租户<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    @PreAuthorize("@xz.hasPermission('sys:tenant:create')")
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
    @PreAuthorize("@xz.hasPermission('sys:tenant:update')")
    @PostMapping(value = "/updateTenant")
    public ResponseResult<Object> updateTenant(@RequestBody @Validated TenantDTO tenantDTO) {
        tenantService.updateTenant(tenantDTO);
        return ResponseResult.ok();
    }


    /**
     * 查询租户详情
     *
     * @param id 租户ID
     * @return 租户详情
     */
    @PreAuthorize("@xz.hasPermission('sys:tenant:update,sys:tenant:create')")
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
    @PreAuthorize("@xz.hasPermission('sys:tenant:enable')")
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
    @PreAuthorize("@xz.hasPermission('sys:tenant:disable')")
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
    @PreAuthorize("@xz.hasPermission('sys:tenant:create','sys:tenant:update')")
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<TenantVO>> list(@RequestBody TenantPage tenantPage) {
        return ResponseResult.ok();
    }

}
