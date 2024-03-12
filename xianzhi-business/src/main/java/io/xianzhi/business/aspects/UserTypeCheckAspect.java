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

package io.xianzhi.business.aspects;

import io.xianzhi.business.annotations.UserTypeCheck;
import io.xianzhi.business.context.XianZhiUserContext;
import io.xianzhi.business.enums.UserTypeEnum;
import io.xianzhi.common.code.CommonCode;
import io.xianzhi.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 租户信息检查切面<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Aspect
public class UserTypeCheckAspect {


    /**
     * 定义切面
     *
     * @param joinPoint 切点
     */
    @Before("@annotation(userTypeCheck)")
    public void process(JoinPoint joinPoint, UserTypeCheck userTypeCheck) {
        String currentUserType = XianZhiUserContext.getCurrentUserType();
        UserTypeEnum usertype = userTypeCheck.usertype();
        if (!currentUserType.equals(usertype.getCode())) {
            log.error("当前用户类型:{},用户ID:{}，访问不具有权限的接口", currentUserType, XianZhiUserContext.getCurrentUserId());
            throw new BizException(CommonCode.FORBIDDEN);
        }
    }
}
