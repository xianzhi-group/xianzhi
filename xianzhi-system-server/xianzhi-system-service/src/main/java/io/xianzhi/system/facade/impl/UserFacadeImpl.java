/*
 * Copyright (c) 2023-2024  XianZhi Group All Rights
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

package io.xianzhi.system.facade.impl;

import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.dao.mappers.UserMapper;
import io.xianzhi.system.facade.UserFacade;
import io.xianzhi.system.model.vo.AuthUserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 用户接口实现<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component
@DubboService
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    /**
     * 用户信息持久层
     */
    private final UserMapper userMapper;


    /**
     * 根据用户名和用户类型加载用户信息
     *
     * @param username 用户名
     * @param userType 用户类型
     * @return 用户信息
     */
    @Override
    public ResponseResult<AuthUserVO> loadAuthUserByUsernameAndUserType(String username, String userType) {
        if (StringUtils.hasText(username) && StringUtils.hasText(userType)) {

            AuthUserVO authUserVO = userMapper.loadAuthUserByUsernameAndUserType(username, userType);
            if (null == authUserVO) {
                log.error("根据用户名和用户类型加载用户信息失败，用户:{}不存在,用户类型:{}", username, userType);
                return ResponseResult.ok();
            }

        }
        log.error("根据用户名加载用户信息失败，用户名不能为空");
        return ResponseResult.fail(CommonCode.PARAMETER_CHECK_FAILED);
    }
}
