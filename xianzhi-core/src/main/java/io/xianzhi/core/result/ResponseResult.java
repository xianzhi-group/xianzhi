package io.xianzhi.core.result;

import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.utils.TraceIdUtil;
import lombok.Getter;

/**
 * 响应结果类<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/15 19:51
 */
@Getter
public class ResponseResult<T> implements Result {

    /**
     * 返回的数据
     */
    private final T data;
    /**
     * TraceId
     */
    private final String traceId;

    /**
     * 返回操作成功响应信息，不带数据
     *
     * @param <R> 返回数据泛型
     * @return 操作成功响应信息
     */
    public static <R> ResponseResult<R> ok() {
        return new ResponseResult<>(CommonCode.SUCCESS, null);
    }

    /**
     * 返回操作成功，带返回数据
     *
     * @param data 返回数据
     * @param <R>  返回数据泛型
     * @return 操作成功响应
     */
    public static <R> ResponseResult<R> ok(R data) {
        return new ResponseResult<>(CommonCode.SUCCESS, data);
    }

    /**
     * 返回操作失败
     *
     * @param result 操作失败响应信息
     * @param <R>    泛型
     * @return 操作失败响应信息
     */
    public static <R> ResponseResult<R> fail(Result result) {
        return new ResponseResult<>(result.success() ? CommonCode.FAIL : result, null);
    }

    /**
     * 返回操作失败
     *
     * @param result 操作失败响应信息
     * @param data   需要返回的数据
     * @param <R>    泛型
     * @return 操作失败响应信息
     */
    public static <R> ResponseResult<R> fail(Result result, R data) {
        return new ResponseResult<>(result.success() ? CommonCode.FAIL : result, data);
    }

    /**
     * 返回操作失败
     *
     * @param data 需要返回的数据
     * @param <R>  泛型
     * @return 操作失败响应信息
     */
    public static <R> ResponseResult<R> fail(R data) {
        return new ResponseResult<>(CommonCode.FAIL, data);
    }


    /**
     * 构造
     *
     * @param result 响应结果
     * @param data   返回的数据
     */
    private ResponseResult(Result result, T data) {
        this.code = result.code();
        this.success = result.success();
        this.message = result.message();
        this.data = data;
        this.traceId = TraceIdUtil.getTraceId();
    }

    /**
     * 自定义状态码
     */
    private final String code;
    /**
     * 是否成功
     */
    private final boolean success;
    /**
     * 提示信息
     */
    private final String message;


    /**
     * 自定义状态码
     *
     * @return 自定义状态码
     */
    @Override
    public String code() {
        return this.code;
    }

    /**
     * 是否操作成功
     *
     * @return 是否操作成功
     */
    @Override
    public boolean success() {
        return this.success;
    }

    /**
     * 自定义提示信息
     *
     * @return 自定义提示信息
     */
    @Override
    public String message() {
        return this.message;
    }
}

