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
     * 设置一个默认的匿名者用户信息上下文，为了解决无法获取用户信息
     * 但是需要保存修改数据的情况获取不到用户信息的问题
     */
    public static void setAnonymousUser() {
        XianZhiUserBO userBO = new XianZhiUserBO();
        userBO.setId("Anonymous");
        set(userBO);
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
