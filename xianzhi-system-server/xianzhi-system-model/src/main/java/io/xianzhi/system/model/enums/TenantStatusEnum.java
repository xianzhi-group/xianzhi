package io.xianzhi.system.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 租户状态枚举<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum TenantStatusEnum {

    /**
     * 禁用
     */
    DISABLE("DISABLE", "禁用"),
    /**
     * 正常
     */
    NORMAL("NORMAL", "正常"),
    /**
     * 未认证
     */
    NOT_CERTIFIED("NOT_CERTIFIED", "未认证"),

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
