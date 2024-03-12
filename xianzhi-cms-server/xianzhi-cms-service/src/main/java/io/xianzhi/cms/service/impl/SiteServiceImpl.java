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

import io.xianzhi.business.utils.WebUtil;
import io.xianzhi.cms.code.SiteCode;
import io.xianzhi.cms.dao.dataobj.SiteDO;
import io.xianzhi.cms.dao.mapper.SiteMapper;
import io.xianzhi.cms.dao.mapper.SiteUserMapper;
import io.xianzhi.cms.manager.SiteManager;
import io.xianzhi.cms.model.page.SitePage;
import io.xianzhi.cms.model.vo.SiteVO;
import io.xianzhi.cms.service.SiteService;
import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.exception.BizException;
import io.xianzhi.common.result.ListResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 站点接口实现<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService {
    /**
     * 站点信息持久层
     */
    private final SiteMapper siteMapper;
    /**
     * 站点用户信息持久层
     */
    private final SiteUserMapper siteUserMapper;

    /**
     * 站点管理
     */
    private final SiteManager siteManager;


    /**
     * 获取当前用户所属具有的站点信息
     *
     * @return 站点信息
     */
    @Override
    public List<SiteVO> me() {
        return null;
    }

    /**
     * 查询租户下的站点列表
     *
     * @param sitePage 查询条件
     * @return 站点列表
     */
    @Override
    public ListResult<SiteVO> list(SitePage sitePage) {
        return null;
    }

    /**
     * 租户删除站点
     *
     * @param id 站点ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(String id) {
        if (StringUtils.hasText(id)) {
            siteManager.checkedTenantUser(WebUtil.getCurrentTenantId(), id);
            SiteDO site = siteManager.getSiteById(id);
            // 判断站点是否存在
            if (null == site) {
                log.error("删除站点失败，站点ID:{}不存在", id);
                throw new BizException(SiteCode.SITE_NOT_EXISTS);
            }
            // 是否是默认站点
            if (site.getDefaultFlag()) {
                throw new BizException(SiteCode.DEFAULT_SITE_NOT_SUPPORT_DELETED);
            }
            // 删除站点
            siteMapper.deleted(id);
            // 删除站点用户关联信息
            siteUserMapper.deletedBySiteId(id);
            // 发布站点删除事件
            siteManager.publishSiteDeletedEvent(id);
        }
        log.error("删除站点失败，站点ID为空");
        throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
    }

    /**
     * 查询站点详情
     *
     * @param id 站点ID
     * @return 站点详情
     */
    @Override
    public SiteVO details(String id) {
        if (StringUtils.hasText(id)) {

        }
        log.error("查询站点详情失败，站点ID为空");
        throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
    }
}
