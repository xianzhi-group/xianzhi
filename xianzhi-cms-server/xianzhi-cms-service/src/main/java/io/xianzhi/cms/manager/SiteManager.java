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

package io.xianzhi.cms.manager;

import io.xianzhi.boot.redis.RedisHandler;
import io.xianzhi.cms.dao.dataobj.SiteDO;
import io.xianzhi.cms.dao.mapper.SiteUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 站点管理<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SiteManager {

    /**
     * Redis操作
     */
    private final RedisHandler redisHandler;
    /**
     * 站点用户信息持久层
     */
    private final SiteUserMapper siteUserMapper;


    public void checkedTenantUser(String tenantId, String id) {

    }


    /**
     * 根据ID查询站点信息
     *
     * @param id 站点ID
     * @return 站点信息
     */
    public SiteDO getSiteById(String id) {
        return null;
    }


    /**
     * 发布站点删除事件
     *
     * @param id 站点ID
     */
    public void publishSiteDeletedEvent(String id) {

    }


}
