package io.xianzhi.system.service;

import io.xianzhi.system.model.dto.UserDTO;

/**
 * 用户信息接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public interface UserService {
    /**
     * 新增用户
     *
     * @param userDTO 用户信息入参
     * @return 用户ID
     */
    String createUser(UserDTO userDTO);
}
