package io.xianzhi.system.model.dto;

import io.xianzhi.system.model.enums.TenantTypeEnum;
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
