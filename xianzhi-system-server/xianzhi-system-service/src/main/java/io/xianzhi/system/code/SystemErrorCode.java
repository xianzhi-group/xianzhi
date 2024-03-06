package io.xianzhi.system.code;

import io.xianzhi.common.result.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统服务错误码<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum SystemErrorCode implements Result {
    /**
     * 租户不存在
     */
    TENANT_NOT_EXISTS("10001", false, "tenant.not.exist"),
    /**
     * 租户名称已存在
     */
    TENANT_NAME_EXISTS("10002", false, "tenant.name.exists"),
    /**
     * 租户编码已存在
     */
    TENANT_CODE_EXISTS("10003", false, "tenant.code.exists"),
    ;
    /**
     * custom response status code
     */
    private final String code;
    /**
     * whether the operation was successful or not
     */
    private final boolean success;
    /**
     * custom prompt information
     */
    private final String message;


    /**
     * This method returns custom response status codes,
     * non HTTP status codes, or other response status codes
     *
     * @return custom response status code
     */
    @Override
    public String code() {
        return this.code;
    }

    /**
     * This method returns whether the operation was successful or not
     *
     * @return whether the operation was successful or not
     */
    @Override
    public boolean success() {
        return this.success;
    }

    /**
     * This method returns custom prompt information
     *
     * @return custom prompt information
     */
    @Override
    public String message() {
        return this.message;
    }
}
