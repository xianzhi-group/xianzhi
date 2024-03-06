package io.xianzhi.business.utils;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * web工具类<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public class WebUtil {

    public static final String TENANT_ID = "X-Tenant-Id";

    /**
     * 获取Request对象
     *
     * @return Request对象
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }


    /**
     * 获取当前租户ID
     *
     * @return 租户ID
     */
    public static String getCurrentTenantId() {
        return WebUtil.getRequest().getHeader(TENANT_ID);
    }
}
