/*
 * Copyright (c) 2023-2023  XianZhi Group (team@xianzhi.io) All Rights
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

package io.xianzhi.core.result;

import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.utils.TraceIdUtil;
import lombok.Getter;

/**
 * 响应结果类<br>
 *
 * @author Max
 * @since 1.0.0
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

