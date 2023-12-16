package io.xianzhi.core.utils;

import cn.hutool.core.util.IdUtil;
import io.xianzhi.core.constants.SystemConstant;
import org.slf4j.MDC;

/**
 * TraceID工具类<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/15 19:49
 */
public class TraceIdUtil {


    private TraceIdUtil() {
    }

    /**
     * 获取当前TraceId
     *
     * @return 当前traceId
     */
    public static String getTraceId() {
        return MDC.get(SystemConstant.TRACE_ID);
    }

    /**
     * 生成traceId
     *
     * @return traceId
     */
    public static String generate() {
        return IdUtil.fastSimpleUUID();
    }


}
