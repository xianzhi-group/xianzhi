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

import io.xianzhi.business.context.XianZhiUserContext;
import io.xianzhi.business.enums.UserTypeEnum;
import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.exception.BizException;
import io.xianzhi.system.code.SystemErrorCode;
import io.xianzhi.system.dao.dataobj.*;
import io.xianzhi.system.dao.mappers.*;
import io.xianzhi.system.manager.AreaManager;
import io.xianzhi.system.manager.DictManager;
import io.xianzhi.system.manager.RoleManager;
import io.xianzhi.system.manager.TenantManager;
import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.enums.DictEnum;
import io.xianzhi.system.model.enums.TenantStatusEnum;
import io.xianzhi.system.model.enums.TenantTypeEnum;
import io.xianzhi.system.model.vo.TenantVO;
import io.xianzhi.system.service.TenantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
     * 区域管理
     */
    private final AreaManager areaManager;
    /**
     * 用户租户关联关系持久层
     */
    private final UserTenantMapper userTenantMapper;
    /**
     * 角色管理
     */
    private final RoleManager roleManager;
    /**
     * 用户角色信息持久层
     */
    private final UserRoleMapper userRoleMapper;
    /**
     * 岗位信息持久层
     */
    private final PostMapper postMapper;
    /**
     * 部门信息持久层
     */
    private final DeptMapper deptMapper;
    /**
     * 字典管理
     */
    private final DictManager dictManager;
    /**
     * 用户部门关联关系持久层
     */
    private final UserDeptMapper userDeptMapper;
    /**
     * 用户岗位关联关系持久层
     */
    private final UserPostMapper userPostMapper;

    /**
     * 创建租户<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createTenant(TenantDTO tenantDTO) {
        // 保存租户信息
        TenantDO tenantDO = checkedTenantDto(tenantDTO);
        tenantMapper.insert(tenantDO);
        // 构建租户和用户关联关系
        UserTenantDO userTenantDO = new UserTenantDO();
        userTenantDO.setUserId(XianZhiUserContext.getCurrentUserId());
        userTenantDO.setTenantId(tenantDO.getId());
        userTenantMapper.insert(userTenantDO);
        // 为用户分配默认租户默认角色ID
        UserRoleDO userRoleDO = new UserRoleDO();
        userRoleDO.setUserId(XianZhiUserContext.getCurrentUserId());
        userRoleDO.setRoleId(roleManager.getDefaultTenantAdminRole());
        userRoleMapper.insert(userRoleDO);
        // 初始化岗位信息
        PostDO postDO = new PostDO();
        postDO.setPostName("管理员");
        postDO.setTenantId(tenantDO.getId());
        postMapper.insert(postDO);
        // 保存用户岗位关联关系
        UserPostDO userPostDO = new UserPostDO();
        userPostDO.setPostId(postDO.getId());
        userPostDO.setUserId(XianZhiUserContext.getCurrentUserId());
        userPostMapper.insert(userPostDO);
        // 初始化部门信息
        DeptDO deptDO = new DeptDO();
        deptDO.setDeptName("默认部门");
        deptDO.setTenantId(tenantDO.getId());
        deptMapper.insert(deptDO);
        // 保存用户部门关联关系
        UserDeptDO userDeptDO = new UserDeptDO();
        userDeptDO.setUserId(XianZhiUserContext.getCurrentUserId());
        userDeptDO.setDeptId(deptDO.getId());
        userDeptMapper.insert(userDeptDO);

        return tenantDO.getId();
    }

    /**
     * 修改租户信息<br>
     *
     * @param tenantDTO 租户信息入参
     */
    @Override
    public void updateTenant(TenantDTO tenantDTO) {
        // 检查入参
        TenantDO tenantDO = checkedTenantDto(tenantDTO);
        tenantManager.deletedAllTenantCacheById(tenantDO.getId());
        tenantMapper.updateById(tenantDO);
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
     * 检查租户信息
     *
     * @param tenantDTO 租户信息入参
     * @return 租户信息
     */
    private TenantDO checkedTenantDto(TenantDTO tenantDTO) {
        TenantDO tenantDO;
        // 判断省市区是否存在
        areaManager.checked(tenantDTO.getProvincialId(), tenantDTO.getCityId(), tenantDTO.getAreaId());

        String userType = XianZhiUserContext.getCurrentUserType();
        // 判断租户类型
        String tenantType = userType.equals(UserTypeEnum.SYSTEM.getCode()) ? TenantTypeEnum.SYSTEM.getCode() : TenantTypeEnum.ENTERPRISE.getCode();
        // 判断租户名称是否存在
        if (tenantMapper.existsTenantByTenantNameAndTenantTypeAndIdNot(tenantDTO.getTenantName(), tenantType, null)) {
            throw new BizException(SystemErrorCode.TENANT_NAME_EXISTS);
        }
        if (StringUtils.hasText(tenantDTO.getId())) {
            // 修改操作，检查租户是否存在
            tenantDO = tenantManager.getTenantById(tenantDTO.getId());
            if (null == tenantDO) {
                log.error("检查租户信息入参失败,租户ID:{}不存在", tenantDTO.getId());
                throw new BizException(SystemErrorCode.TENANT_NOT_EXISTS);
            }
        } else {
            tenantDO = new TenantDO();
            // 新增租户默认状态都是正常
            tenantDO.setTenantStatus(TenantStatusEnum.NORMAL.getCode());
            tenantDO.setTenantName(tenantDTO.getTenantName());
            tenantDO.setAuthentication(TenantTypeEnum.SYSTEM.getCode().equals(tenantType));
            tenantDO.setTenantType(tenantType);
            // 默认都是未认证状态
            tenantDO.setAuthentication(false);
        }

        tenantDO.setProvincialId(tenantDTO.getProvincialId());
        tenantDO.setCityId(tenantDTO.getCityId());
        tenantDO.setAreaId(tenantDTO.getAreaId());
        tenantDO.setTenantLogo(tenantDTO.getTenantLogo());
        if (!dictManager.existsItemById(tenantDTO.getScaleId(), DictEnum.SCALE.getCode())) {
            log.error("检查租户信息入参失败,规模ID:{}不存在", tenantDTO.getScaleId());
            throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
        }
        tenantDO.setIndustryId(tenantDTO.getIndustryId());
        if (!dictManager.existsItemById(tenantDTO.getScaleId(), DictEnum.INDUSTRY.getCode())) {
            log.error("检查租户信息入参失败,行业ID:{}不存在", tenantDTO.getScaleId());
            throw new BizException(CommonCode.PARAMETER_CHECK_FAILED);
        }
        tenantDO.setTenantDesc(tenantDTO.getTenantDesc());
        return tenantDO;
    }

}
