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
import io.xianzhi.system.model.page.TenantPage;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.service.admin.AdminTenantService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 租户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
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
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<TenantVO>> list(TenantPage tenantPage) {
        return ResponseResult.ok();
    }


    /**
     * 删除租户<br>
     *
     * @param id 租户ID
     * @return 响应信息
     */
    @PreAuthorize("@xz.hasPermission('sys:tenant:deleted')")
    @PostMapping(value = "/deleted/{id}")
    public ResponseResult<Object> deleteTenant(@PathVariable(value = "id") String id) {
        return ResponseResult.ok();
    }
}
