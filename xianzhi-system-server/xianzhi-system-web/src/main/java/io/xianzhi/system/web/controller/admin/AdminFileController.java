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

import io.xianzhi.common.result.ListResult;
import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.page.FilePage;
import io.xianzhi.system.model.vo.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员文件接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mng/file")
public class AdminFileController {

    /**
     * 文件列表
     *
     * @param filePage 文件分页
     * @return 文件列表
     */
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<FileVO>> list(FilePage filePage) {
        return ResponseResult.ok();
    }

    /**
     * 删除文件
     *
     * @param id 文件ID
     * @return 响应信息
     */
    @PostMapping(value = "/deleted")
    public ResponseResult<Object> deleted(String id) {
        return ResponseResult.ok();
    }


}
