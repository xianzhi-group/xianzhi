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

package io.xianzhi.cms.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.xianzhi.cms.dao.dataobj.SiteDO;
import io.xianzhi.cms.model.page.SitePage;
import io.xianzhi.cms.model.vo.SiteVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 站点信息持久层<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Mapper
public interface SiteMapper extends BaseMapper<SiteDO> {


    /**
     * 根据租户ID和用户ID查询站点信息
     *
     * @param tenantId 租户ID
     * @param userId   用户ID
     * @return 站点信息
     */
    List<SiteVO> querySiteByTenantIdAndUserId(String tenantId, String userId);

    /**
     * 查询站点列表
     *
     * @param page     分页信息
     * @param sitePage 站点查询条件
     * @return 站点列表
     */
    IPage<SiteVO> querySiteByPage(IPage<SiteVO> page, SitePage sitePage);


    /**
     * 根据站点ID查询站点信息
     *
     * @param id 站点ID
     * @return 站点信息
     */
    SiteDO querySiteById(String id);

    /**
     * 根据租户ID查询站点信息
     *
     * @param tenantId 租户ID
     * @return 站点信息
     */
    List<SiteDO> querySiteByTenantId(String tenantId);
}
