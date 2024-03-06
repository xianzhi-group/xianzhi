package io.xianzhi.business.context;

import io.xianzhi.business.enums.UserTypeEnum;
import io.xianzhi.common.context.UserBO;
import lombok.Data;

/**
 * 用户信息<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Data
public class XianZhiUserBO implements UserBO {


    private String id;


    private String username;

    /**
     * 租户类型 {@link UserTypeEnum#getCode()}
     */
    private String userType;

    /**
     * Get User id
     *
     * @return user id
     */
    @Override
    public String getUserId() {
        return null;
    }
}
