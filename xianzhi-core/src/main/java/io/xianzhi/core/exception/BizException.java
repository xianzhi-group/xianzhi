package io.xianzhi.core.exception;

import io.xianzhi.core.result.Result;
import lombok.Getter;

/**
 * 自定义业务异常<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/15 19:34
 */
@Getter
public class BizException extends RuntimeException {
    /**
     * 自定义响应信息
     */
    private final transient Result result;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BizException(Result result) {
        super(result.message());
        this.result = result;
    }
}
