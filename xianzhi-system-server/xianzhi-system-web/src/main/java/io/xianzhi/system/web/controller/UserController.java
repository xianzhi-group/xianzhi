package io.xianzhi.system.web.controller;

import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 新增用户
     *
     * @param userDTO 用户信息入参
     * @return 响应信息
     */
    public ResponseResult<String> createUser(UserDTO userDTO) {
        return null;
    }


}
