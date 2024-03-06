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
