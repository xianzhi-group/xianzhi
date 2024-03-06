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

package io.xianzhi.system.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 租户信息入参<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Data
public class TenantDTO implements Serializable {

    /**
     * 租户ID
     */
    private String id;
    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * 租户编码
     */
    private String tenantCode;
    /**
     * 租户类型 {@link io.xianzhi.system.model.enums.TenantTypeEnum#getCode
     */
    private String tenantType;
    /**
     * 租户状态 {@link io.xianzhi.system.model.enums.TenantStatusEnum#getCode}
     */
    private String tenantStatus;
    /**
     * 租户描述
     */
    private String tenantDesc;
    /**
     * 租户图标
     */
    private String tenantLogo;
    /**
     * 租户地址
     */
    private String tenantAddress;
    /**
     * 租户联系电话
     */
    private String tenantPhone;
    /**
     * 租户联系邮箱
     */
    private String tenantEmail;
    /**
     * 租户联系人
     */
    private String tenantContact;
    /**
     * 租户联系人电话
     */
    private String tenantContactPhone;
    /**
     * 租户联系人邮箱
     */
    private String tenantContactEmail;
    /**
     * 租户联系人地址
     */
    private String tenantContactAddress;
    /**
     * 租户联系人邮编
     */
    private String tenantContactPostcode;
    /**
     * 租户联系人微信
     */
    private String tenantContactWechat;
    /**
     * 租户联系人QQ
     */
    private String tenantContactQq;


}
