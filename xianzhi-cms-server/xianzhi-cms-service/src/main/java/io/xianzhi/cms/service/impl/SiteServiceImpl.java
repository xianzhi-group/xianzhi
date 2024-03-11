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

import io.xianzhi.business.context.XianZhiUserContext;
import io.xianzhi.business.enums.UserTypeEnum;
import io.xianzhi.business.utils.WebUtil;
import io.xianzhi.cms.dao.mapper.SiteMapper;
import io.xianzhi.cms.dao.mapper.SiteUserMapper;
import io.xianzhi.cms.model.vo.SiteVO;
import io.xianzhi.cms.service.SiteService;
import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.exception.BizException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
     * 获取当前用户所属具有的站点信息
     *
     * @return 站点信息
     */
    @Override
    public List<SiteVO> me() {
        String userId = XianZhiUserContext.getCurrentUserId();
        String userType = XianZhiUserContext.getCurrentUserType();
        if (userType.equals(UserTypeEnum.SYSTEM.getCode())) {
            return siteMapper.querySiteByUserId(userId);
        } else if (userType.equals(UserTypeEnum.ENTERPRISE.getCode())) {
            String tenantId = WebUtil.getCurrentTenantId();
            // 检查用户是否属于该租户
            checkedTenantUser(tenantId, userId);
            return siteMapper.querySiteByTenantIdAndUserId(tenantId, userId);
        } else {
            log.error("用户类型错误，userId:{}", userId);
            throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
        }
    }

    /**
     * 检查用户是否属于该租户
     *
     * @param tenantId 租户ID
     * @param userId   用户ID
     */
    private void checkedTenantUser(String tenantId, String userId) {

    }
}
