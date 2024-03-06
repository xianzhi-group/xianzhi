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

package io.xianzhi.system.converts;

import io.xianzhi.system.dao.dataobj.TenantDO;
import io.xianzhi.system.model.dto.TenantDTO;

/**
 * 租户信息转换<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public class TenantConvert {

    /**
     * 租户信息转换<br>
     *
     * @param tenantDO 租户信息
     * @return 租户信息
     */
    public static TenantDTO convert(TenantDO tenantDO) {
        if (tenantDO == null) {
            return null;
        }
        TenantDTO tenantDTO = new TenantDTO();
        tenantDTO.setId(tenantDO.getId());
        tenantDTO.setTenantName(tenantDO.getTenantName());
        tenantDTO.setTenantCode(tenantDO.getTenantCode());
        tenantDTO.setTenantType(tenantDO.getTenantType());
        tenantDTO.setTenantStatus(tenantDO.getTenantStatus());
        tenantDTO.setTenantDesc(tenantDO.getTenantDesc());
        tenantDTO.setTenantLogo(tenantDO.getTenantLogo());
        tenantDTO.setTenantAddress(tenantDO.getTenantAddress());
        tenantDTO.setTenantPhone(tenantDO.getTenantPhone());
        tenantDTO.setTenantEmail(tenantDO.getTenantEmail());
        tenantDTO.setTenantContact(tenantDO.getTenantContact());
        tenantDTO.setTenantContactPhone(tenantDO.getTenantContactPhone());
        tenantDTO.setTenantContactEmail(tenantDO.getTenantContactEmail());
        tenantDTO.setTenantContactAddress(tenantDO.getTenantContactAddress());
        tenantDTO.setTenantContactPostcode(tenantDO.getTenantContactPostcode());
        tenantDTO.setTenantContactWechat(tenantDO.getTenantContactWechat());
        tenantDTO.setTenantContactQq(tenantDO.getTenantContactQq());
        return tenantDTO;
    }
}
