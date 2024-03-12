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

package io.xianzhi.system.service.admin.impl;

import io.xianzhi.business.context.XianZhiUserContext;
import io.xianzhi.common.result.ListResult;
import io.xianzhi.system.dao.dataobj.TenantDO;
import io.xianzhi.system.dao.mappers.TenantMapper;
import io.xianzhi.system.model.enums.TenantStatusEnum;
import io.xianzhi.system.model.enums.TenantTypeEnum;
import io.xianzhi.system.model.page.TenantPage;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.service.admin.AdminTenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 管理员租户接口实现<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AdminTenantServiceImpl implements AdminTenantService, InitializingBean {
    /**
     * 租户信息持久层
     */
    private final TenantMapper tenantMapper;

    /**
     * 查询所有租户列表
     *
     * @param tenantPage 查询条件
     * @return 租户列表
     */
    @Override
    public ListResult<TenantVO> list(TenantPage tenantPage) {
        return null;
    }

    /**
     * 在系统启动时候判断是否初始化过系统租户，如果没有就默认初始化一个系统租户
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (!tenantMapper.existsSystemTenant()) {
            XianZhiUserContext.setAnonymousUser();
            log.info("初始化系统租户");
            TenantDO tenantDO = new TenantDO();
            tenantDO.setTenantName("系统租户");
            tenantDO.setTenantType(TenantTypeEnum.SYSTEM.getCode());
            tenantDO.setTenantStatus(TenantStatusEnum.NORMAL.getCode());
            tenantDO.setAuthentication(true);
            tenantDO.setDefaultFlag(true);
            tenantMapper.insert(tenantDO);
            log.info("初始化系统租户成功,租户ID:{}", tenantDO.getId());
        }
    }
}
