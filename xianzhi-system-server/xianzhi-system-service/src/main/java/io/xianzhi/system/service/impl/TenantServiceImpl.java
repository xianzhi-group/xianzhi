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

package io.xianzhi.system.service.impl;

import io.xianzhi.common.exception.BizException;
import io.xianzhi.system.code.SystemErrorCode;
import io.xianzhi.system.dao.dataobj.TenantDO;
import io.xianzhi.system.dao.mappers.TenantMapper;
import io.xianzhi.system.manager.TenantManager;
import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
     * 租户信息持久层
     */
    private final TenantMapper tenantMapper;
    /**
     * 租户管理
     */
    private final TenantManager tenantManager;

    /**
     * 创建租户<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    @Override
    public String createTenant(TenantDTO tenantDTO) {
        TenantDO tenantDO = checkTenantDto(tenantDTO);
        tenantMapper.insert(tenantDO);
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

    /**
     * 检查租户信息<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 租户信息实体
     */
    private TenantDO checkTenantDto(TenantDTO tenantDTO) {
        TenantDO tenantDO;
        // 判断租户名称是否存在
        if (tenantMapper.existsTenantByTenantNameAndTenantTypeAndIdNot(tenantDTO.getTenantName(), tenantDTO.getTenantType(), tenantDTO.getId())) {
            throw new BizException(SystemErrorCode.TENANT_NAME_EXISTS);
        }
        if (StringUtils.hasText(tenantDTO.getId())) {
            tenantDO = tenantManager.getTenantById(tenantDTO.getId());
            if (tenantDO == null) {
                throw new BizException(SystemErrorCode.TENANT_NOT_EXISTS);
            }

        } else {
            tenantDO = new TenantDO();
            // 判断租户Code是否存在
            if (tenantMapper.existsTenantByTenantCode(tenantDTO.getTenantCode())) {
                throw new BizException(SystemErrorCode.TENANT_CODE_EXISTS);
            }
        }
        return tenantDO;
    }
}
