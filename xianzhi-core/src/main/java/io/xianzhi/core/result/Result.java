package io.xianzhi.core.result;

/**
 * 响应结果<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/15 19:26
 */
public interface Result {

    /**
     * 返回自定义状态码
     *
     * @return 自定义状态码
     */
    String code();

    /**
     * 返回是否操作成功
     *
     * @return 是否操作成功
     */
    boolean success();

    /**
     * 返回自定义提示信息
     *
     * @return 自定义提示信息
     */
    String message();
}

