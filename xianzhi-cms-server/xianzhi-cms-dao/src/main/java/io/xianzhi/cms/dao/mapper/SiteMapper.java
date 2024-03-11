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
import io.xianzhi.cms.dao.dataobj.SiteDO;
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
     * 根据用户ID查询站点信息
     *
     * @param userId 用户ID
     * @return 站点信息
     */
    List<SiteVO> querySiteByUserId(String userId);

    /**
     * 根据租户ID和用户ID查询站点信息
     *
     * @param tenantId 租户ID
     * @param userId   用户ID
     * @return 站点信息
     */
    List<SiteVO> querySiteByTenantIdAndUserId(String tenantId, String userId);
}
