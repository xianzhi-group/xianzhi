package io.xianzhi.core.context;

import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户信息上下文<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/15 19:27
 */
@Slf4j
public class UserContext {

    /**
     * 用户信息上下文
     */
    private static final ThreadLocal<UserBO> USER_BO_THREAD_LOCAL = new InheritableThreadLocal<>();


    /**
     * 获取用户当前用户ID
     *
     * @return 当前用户ID
     */
    public static String getCurrentUserId() {
        return getCurrentUser().getId();
    }

    /**
     * 获取当前用户信息
     *
     * @return 当前用户信息
     */
    public static UserBO getCurrentUser() {
        UserBO userBO = USER_BO_THREAD_LOCAL.get();
        if (null == userBO) {
            throw new BizException(CommonCode.UNAUTHORIZED);
        }
        return userBO;
    }

    /**
     * 设置用户上下文
     *
     * @param user 上下文用户信息
     */
    public static void set(UserBO user) {
        if (null == user) {
            throw new BizException(CommonCode.UNAUTHORIZED);
        }
        USER_BO_THREAD_LOCAL.set(user);
    }

    /**
     * 清除用户上下文
     */
    public static void remove() {
        USER_BO_THREAD_LOCAL.remove();
    }
}
