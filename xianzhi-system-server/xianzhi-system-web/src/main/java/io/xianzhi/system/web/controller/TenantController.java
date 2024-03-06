package io.xianzhi.system.web.controller;

import io.xianzhi.common.result.ResponseResult;
import io.xianzhi.system.model.dto.TenantDTO;
import io.xianzhi.system.model.vo.TenantVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 租户管理接口<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@RestController
@RestControllerAdvice
@RequestMapping(value = "/tenant")
public class TenantController {
    /**
     * 创建租户<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 租户ID
     */
    @PostMapping(value = "/createTenant")
    public ResponseResult<String> createTenant(TenantDTO tenantDTO) {
        return ResponseResult.ok();
    }

    /**
     * 修改租户信息<br>
     *
     * @param tenantDTO 租户信息入参
     * @return 响应信息
     */
    @PostMapping(value = "/updateTenant")
    public ResponseResult<Object> updateTenant(TenantDTO tenantDTO) {
        return ResponseResult.ok();
    }

    /**
     * 删除租户<br>
     *
     * @param id 租户ID
     * @return 响应信息
     */
    public ResponseResult<Object> deleteTenant(String id) {
        return ResponseResult.ok();
    }

    /**
     * 查询租户详情
     *
     * @param id 租户ID
     * @return 租户详情
     */
    public ResponseResult<TenantVO> details(String id) {
        return ResponseResult.ok();
    }

    /**
     * 启用租户 <br>
     *
     * @param id 租户ID
     * @return 响应信息
     */
    public ResponseResult<Object> enable(String id) {
        return ResponseResult.ok();
    }

    /**
     * 禁用租户 <br>
     *
     * @param id 租户ID
     * @return 响应信息
     */
    public ResponseResult<Object> disable(String id) {
        return ResponseResult.ok();
    }

}
