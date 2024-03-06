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

package io.xianzhi.system.service;

import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.vo.TenantVO;

/**
 * 租户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public interface TenantService {


    /**
     * 创建租户<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    String createTenant(TenantDTO tenantDTO);

    /**
     * 修改租户信息<br>
     *
     * @param tenantDTO 租户信息入参
     */
    void updateTenant(TenantDTO tenantDTO);

    /**
     * 删除租户<br>
     *
     * @param id 租户ID
     */
    void deleteTenant(String id);

    /**
     * 查询租户详情
     *
     * @param id 租户ID
     * @return 租户详情
     */
    TenantVO details(String id);
}
