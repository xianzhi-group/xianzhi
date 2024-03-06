package io.xianzhi.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型枚举<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    /**
     * 系统用户
     */
    SYSTEM("SYSTEM", "系统用户"),
    /**
     * 普通用户
     */
    PERSON("PERSON", "普通用户"),
    /**
     * 企业用户
     */
    ENTERPRISE("ENTERPRISE", "企业用户"),

    ;

    /**
     * 用户类型code
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;
}
