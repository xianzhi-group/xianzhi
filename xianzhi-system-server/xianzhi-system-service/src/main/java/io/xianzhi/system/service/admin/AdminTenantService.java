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
import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.page.TenantPage;
import io.xianzhi.system.model.vo.TenantVO;

/**
 * 管理员租户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public interface AdminTenantService {

    /**
     * 查询所有租户列表
     *
     * @param tenantPage 查询条件
     * @return 租户列表
     */
    ListResult<TenantVO> list(TenantPage tenantPage);


    /**
     * 新增一个租户
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    String createTenant(TenantDTO tenantDTO);


    /**
     * 修改一个租户
     *
     * @param tenantDTO 租户恓入参
     */
    void updateTenant(TenantDTO tenantDTO);
}
