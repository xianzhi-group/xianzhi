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
import io.xianzhi.system.model.dto.DictDTO;
import io.xianzhi.system.model.page.DictPage;
import io.xianzhi.system.model.vo.DictVO;
import io.xianzhi.system.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 字典接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mng/dict")
public class AdminDictController {
    /**
     * 字典服务
     */
    private final DictService dictService;

    /**
     * 新增字典
     *
     * @param dto 字典信息入参
     * @return 字典ID
     */
    @PostMapping(value = "/createDict")
    public ResponseResult<String> createDict(@RequestBody @Validated DictDTO dto) {
        return ResponseResult.ok();
    }

    /**
     * 修改字典信息
     *
     * @param dto 字典信息入参
     * @return 响应信息
     */
    @PostMapping(value = "/updateDict")
    public ResponseResult<Object> updateDict(@RequestBody @Validated DictDTO dto) {
        return ResponseResult.ok();
    }

    /**
     * 删除字典
     *
     * @param id 字典ID
     * @return 响应信息
     */
    @PostMapping(value = "/deleted/{id}")
    public ResponseResult<Object> deleted(@PathVariable(value = "id") String id) {
        return ResponseResult.ok();
    }

    /**
     * 查询字典列表
     *
     * @param dictPage 字典分页查询入参
     * @return 字典列表
     */
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<DictVO>> list(@RequestBody DictPage dictPage) {
        return ResponseResult.ok();
    }
}
