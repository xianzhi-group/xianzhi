package io.xianzhi.system.service.impl;

import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 租户接口实现<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {
    /**
     * 创建租户<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    @Override
    public String createTenant(TenantDTO tenantDTO) {
        return null;
    }

    /**
     * 修改租户信息<br>
     *
     * @param tenantDTO 租户信息入参
     */
    @Override
    public void updateTenant(TenantDTO tenantDTO) {

    }

    /**
     * 删除租户<br>
     *
     * @param id 租户ID
     */
    @Override
    public void deleteTenant(String id) {

    }

    /**
     * 查询租户详情
     *
     * @param id 租户ID
     * @return 租户详情
     */
    @Override
    public TenantVO details(String id) {
        return null;
    }
}
