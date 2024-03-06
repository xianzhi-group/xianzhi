package io.xianzhi.system.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 租户类型枚举<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum TenantTypeEnum {

    /**
     * 系统租户
     */
    SYSTEM("SYSTEM", "系统租户"),
    /**
     * 个人租户
     */
    PERSON("PERSON", "个人租户"),
    /**
     * 企业租户
     */
    ENTERPRISE("ENTERPRISE", "企业租户"),
    ;
    /**
     * code
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;
}
