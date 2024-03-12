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

package io.xianzhi.system.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableField;
import io.xianzhi.boot.mybatis.plus.MyBatisConstant;
import io.xianzhi.boot.mybatis.plus.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户信息实体<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantDO extends BaseDO {
    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * 租户类型 {@link io.xianzhi.system.model.enums.TenantTypeEnum#getCode
     */
    private String tenantType;
    /**
     * 租户状态 {@link io.xianzhi.system.model.enums.TenantStatusEnum#getCode}
     */
    private String tenantStatus;
    /**
     * 是否认证
     */
    @TableField("is_authentication")
    private Boolean authentication;
    /**
     * 租户描述
     */
    private String tenantDesc;
    /**
     * 租户图标
     */
    private String tenantLogo;
    /**
     * 省级ID
     */
    private String provincialId;
    /**
     * 市级ID
     */
    private String cityId;
    /**
     * 区级ID
     */
    private String areaId;

    /**
     * 行业ID
     */
    private String industryId;

    /**
     * 规模ID
     */
    private String scaleId;

    /**
     * 是否默认租户
     */
    @TableField(value = MyBatisConstant.IS_DEFAULT)
    private Boolean defaultFlag;

}
