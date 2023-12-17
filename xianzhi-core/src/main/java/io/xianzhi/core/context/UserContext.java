/*
 * Copyright (c) 2023-2023  XianZhi Group (team@xianzhi.io) All Rights
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

package io.xianzhi.core.context;

import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;

/**
 * 用户信息上下文<br>
 *
 * @author Max
 * @since 1.0.0
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
