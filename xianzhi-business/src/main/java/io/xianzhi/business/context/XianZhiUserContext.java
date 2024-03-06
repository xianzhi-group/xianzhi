package io.xianzhi.business.context;

import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.context.UserBO;
import io.xianzhi.common.context.UserContext;
import io.xianzhi.common.exception.BizException;

/**
 * 用户信息上下文<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public class XianZhiUserContext extends UserContext {

    /**
     * 获取当前用户类型
     *
     * @return 当前用户类型
     */
    public static String getCurrentUserType() {
        return getXianZhiUser().getUserType();
    }

    /**
     * 获取用户信息上下文
     *
     * @return 用户信息上下文
     */
    private static XianZhiUserBO getXianZhiUser() {
        UserBO userBO = UserContext.get();
        if (null == userBO) {
            throw new BizException(CommonCode.UNAUTHORIZED);
        }

        return (XianZhiUserBO) userBO;
    }


}
