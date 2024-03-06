package io.xianzhi.system.service.impl;

import io.xianzhi.business.context.XianZhiUserContext;
import io.xianzhi.system.model.dto.UserDTO;
import io.xianzhi.system.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    /**
     * 新增用户
     *
     * @param userDTO 用户信息入参
     * @return 用户ID
     */
    @Override
    public String createUser(UserDTO userDTO) {
        String currentUserType = XianZhiUserContext.getCurrentUserType();

        return null;
    }
}
