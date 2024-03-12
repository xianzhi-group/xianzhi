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

package io.xianzhi.cms.service.impl;

import com.alibaba.fastjson2.JSON;
import io.xianzhi.business.model.DisableDTO;
import io.xianzhi.cms.code.SiteCode;
import io.xianzhi.cms.dao.dataobj.SiteDO;
import io.xianzhi.cms.dao.dataobj.SiteUserDO;
import io.xianzhi.cms.dao.mapper.SiteMapper;
import io.xianzhi.cms.dao.mapper.SiteUserMapper;
import io.xianzhi.cms.model.page.SitePage;
import io.xianzhi.cms.model.vo.SiteVO;
import io.xianzhi.cms.service.AdminSiteService;
import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.exception.BizException;
import io.xianzhi.common.result.ListResult;
import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.facade.TenantFacade;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.model.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 管理员站点接口实现<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AdminSiteServiceImpl implements AdminSiteService {

    /**
     * 租户接口
     */
    @DubboReference
    private TenantFacade tenantFacade;

    /**
     * 站点信息持久层
     */
    private final SiteMapper siteMapper;

    /**
     * 站点用户信息持久层
     */
    private final SiteUserMapper siteUserMapper;

    /**
     * 查询站点列表
     *
     * @param sitePage 站点查询条件
     * @return 站点列表
     */
    @Override
    public ListResult<SiteVO> list(SitePage sitePage) {
        return null;
    }

    /**
     * 查询站点详情
     *
     * @param id 站点ID
     * @return 站点详情
     */
    @Override
    public SiteVO details(String id) {
        return null;
    }

    /**
     * 新增站点
     *
     * @param id 站点ID
     */
    @Override
    public void deleted(String id) {

    }

    /**
     * 启用站点
     *
     * @param id 站点ID
     */
    @Override
    public void enable(String id) {

    }

    /**
     * 禁用站点
     *
     * @param dto 禁用入参
     */
    @Override
    public void disable(DisableDTO dto) {

    }

    /**
     * 为租户开启默认站点
     *
     * @param tenantId 租户ID
     */
    @Override
    public void openDefaultSite(String tenantId) {
        List<SiteDO> sites = siteMapper.querySiteByTenantId(tenantId);
        if (ObjectUtils.isEmpty(sites)) {
            ResponseResult<TenantVO> tenantInfo = tenantFacade.getTenantInfo(tenantId);
            if (!tenantInfo.isSuccess()) {
                log.error("获取租户信息失败，租户ID:{},响应信息:{}", tenantId, JSON.toJSONString(tenantInfo));
                throw new BizException(tenantInfo);
            }
            TenantVO tenant = tenantInfo.getData();
            if (null == tenant) {
                log.error("获取租户信息为空，租户ID:{}", tenantId);
                throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
            }
            UserVO admin = tenant.getAdmin();
            if (null == admin) {
                log.error("获取租户管理员信息为空，租户ID:{}", tenantId);
                throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
            }
            String tenantAdminId = admin.getId();
            if (!StringUtils.hasText(tenantAdminId)) {
                log.error("获取租户管理员ID为空，租户ID:{}", tenantId);
                throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
            }
            // 构建默认站点
            SiteDO defaultSite = new SiteDO();
            defaultSite.setTenantId(tenantId);
            defaultSite.setSiteName("主站");
            defaultSite.setDefaultFlag(true);
            defaultSite.setSiteAdmin(tenantAdminId);
            siteMapper.insert(defaultSite);
            // 构建站点和用户的关系
            SiteUserDO siteUserDO = new SiteUserDO();
            siteUserDO.setUserId(tenantAdminId);
            siteUserDO.setSiteId(defaultSite.getId());
            siteUserMapper.insert(siteUserDO);
        }
        throw new BizException(SiteCode.DEFAULT_SITE_EXISTS);

    }
}
