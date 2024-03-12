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

package io.xianzhi.system.service.admin.impl;

import io.xianzhi.common.result.ListResult;
import io.xianzhi.system.dao.mappers.UserMapper;
import io.xianzhi.system.model.page.UserPage;
import io.xianzhi.system.model.vo.UserVO;
import io.xianzhi.system.service.admin.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 管理员用户接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {

    /**
     * 用户信息持久层
     */
    private final UserMapper userMapper;

    /**
     * 用户列表
     *
     * @param userPage 用户查询条件
     * @return 用户列表
     */
    @Override
    public ListResult<UserVO> list(UserPage userPage) {
        return null;
    }
}
