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

package io.xianzhi.boot.web.handler;

import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BizException;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * 全局异常处理<br>
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理
     *
     * @param exception ex
     * @return 响应信息
     */
    @ExceptionHandler(value = BizException.class)
    public ResponseResult<Object> bizException(BizException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseResult.fail(exception.getResult());
    }

    /**
     * 未知异常处理
     *
     * @param exception ex
     * @return 响应信息
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseResult<Object> exception(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ResponseResult.fail(CommonCode.ERROR);
    }

    /**
     * 处理空指针异常
     *
     * @param exception ex
     * @return 响应信息
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseResult<Object> nullPointerException(NullPointerException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseResult.fail(CommonCode.NULL_POINTER_EXCEPTION);
    }

    /**
     * Content-Type 错误处理
     *
     * @param exception ex
     * @return 响应信息
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseResult<Object> HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseResult.fail(CommonCode.HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION);
    }

    /**
     * '@RequestParam' 指定的参数没有获取到
     *
     * @param exception ex
     * @return 响应信息
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseResult<Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseResult.fail(CommonCode.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION);
    }

    /**
     * 请求参数校验错误
     *
     * @param exception ex
     * @return 响应信息
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String msg = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();
        return ResponseResult.fail(new Result() {
            @Override
            public String code() {
                return CommonCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION.code();
            }

            @Override
            public boolean success() {
                return false;
            }

            @Override
            public String message() {
                return msg;
            }
        });
    }
}
