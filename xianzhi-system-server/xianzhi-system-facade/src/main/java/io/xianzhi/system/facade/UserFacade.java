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

package io.xianzhi.system.facade;

import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.vo.AuthUserVO;

/**
 * 用户信息接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
public interface UserFacade {


    /**
     * 根据用户名和用户类型加载用户信息
     *
     * @param username 用户名
     * @param userType 用户类型
     * @return 用户信息
     */
    ResponseResult<AuthUserVO> loadAuthUserByUsernameAndUserType(String username, String userType);
}
