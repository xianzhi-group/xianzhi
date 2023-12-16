package io.xianzhi.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型枚举<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/15 19:44
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    /**
     * 系统用户
     */
    SYSTEM("system", "系统用户"),
    /**
     * 普通用户
     */
    USER("user", "普通用户"),
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

