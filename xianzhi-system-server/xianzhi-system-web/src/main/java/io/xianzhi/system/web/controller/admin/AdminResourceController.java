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

package io.xianzhi.system.web.controller.admin;

import io.xianzhi.business.annotations.UserTypeCheck;
import io.xianzhi.business.enums.UserTypeEnum;
import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.vo.ResourceVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理员资源接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mng/resource")
public class AdminResourceController {


    /**
     * 查询我的资源
     *
     * @return 我的资源
     */
    @GetMapping(value = "/me")
    @UserTypeCheck(usertype = UserTypeEnum.SYSTEM)
    public ResponseResult<List<ResourceVO>> me() {
        return ResponseResult.ok();
    }
}
