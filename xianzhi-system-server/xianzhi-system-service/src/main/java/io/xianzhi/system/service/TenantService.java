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
