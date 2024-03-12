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

package io.xianzhi.cms.web.controller.mng;

import io.xianzhi.business.model.DisableDTO;
import io.xianzhi.cms.model.page.SitePage;
import io.xianzhi.cms.model.vo.SiteVO;
import io.xianzhi.cms.service.AdminSiteService;
import io.xianzhi.common.result.ListResult;
import io.xianzhi.common.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员站点接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mng/site")
public class SiteController {

    /**
     * 管理员站点服务
     */
    private final AdminSiteService adminSiteService;

    /**
     * 管理员查询站点列表
     *
     * @param sitePage 站点查询条件
     * @return 站点列表
     */
    @PostMapping(value = "/list")
    public ResponseResult<ListResult<SiteVO>> list(SitePage sitePage) {
        return ResponseResult.ok(adminSiteService.list(sitePage));
    }

    /**
     * 管理员查询站点详情,包含租户信息，租户对应站点的用户信息
     *
     * @param id 站点ID
     * @return 站点详情
     */
    @GetMapping(value = "/details/{id}")
    public ResponseResult<SiteVO> details(@PathVariable(value = "id") String id) {
        return ResponseResult.ok(adminSiteService.details(id));
    }

    /**
     * 管理员禁用站点
     *
     * @param disableDTO 禁用入参
     * @return 响应信息
     */
    @PostMapping(value = "/disable")
    public ResponseResult<Object> disable(@RequestBody @Validated DisableDTO disableDTO) {
        adminSiteService.disable(disableDTO);
        return ResponseResult.ok();
    }

    /**
     * 管理员为租户开通默认站点
     *
     * @param tenantId 租户ID
     * @return 响应信息
     */
    @PostMapping(value = "/openDefaultSite/{tenantId}")
    public ResponseResult<Object> openDefaultSite(@PathVariable(value = "tenantId") String tenantId) {
        adminSiteService.openDefaultSite(tenantId);
        return ResponseResult.ok();
    }


}
