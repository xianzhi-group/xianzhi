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

package io.xianzhi.cms.web.controller;

import io.xianzhi.cms.model.dto.SiteDTO;
import io.xianzhi.cms.model.page.SitePage;
import io.xianzhi.cms.model.vo.SiteVO;
import io.xianzhi.cms.service.SiteService;
import io.xianzhi.common.result.ListResult;
import io.xianzhi.common.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 站点接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/site")
public class SiteController {

    /**
     * 站点服务
     */
    private final SiteService siteService;

    /**
     * 获取当前用户所具有的站点信息
     *
     * @return 当前用户所具有的站点信息
     */
    @PostMapping(value = "/me")
    public ResponseResult<List<SiteVO>> me() {
        return ResponseResult.ok(siteService.me());
    }

    /**
     * 查询站点列表
     *
     * @param sitePage 站点查询条件
     * @return 站点列表
     */
    public ResponseResult<ListResult<SiteVO>> list(SitePage sitePage) {
        sitePage.setAdmin(false);
        return ResponseResult.ok(siteService.list(sitePage));
    }

    /**
     * 查询站点详情
     *
     * @param id 站点ID
     * @return 站点详情
     */
    public ResponseResult<SiteVO> details(String id) {
        return ResponseResult.ok(siteService.details(id));
    }

    /**
     * 删除站点
     *
     * @param id 站点ID
     * @return 响应信息
     */
    @PostMapping(value = "/deleted/{id}")
    public ResponseResult<Object> deleted(@PathVariable(value = "id") String id) {
        siteService.deleted(id);
        return ResponseResult.ok();
    }


    public ResponseResult<String> create(SiteDTO siteDTO) {
        return ResponseResult.ok();
    }


    public ResponseResult<Object> update(SiteDTO siteDTO) {
        return ResponseResult.ok();
    }
}
