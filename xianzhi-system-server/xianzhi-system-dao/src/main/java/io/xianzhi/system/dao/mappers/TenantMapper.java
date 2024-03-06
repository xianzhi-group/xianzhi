package io.xianzhi.system.dao.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.system.dao.dataobj.TenantDO;
import io.xianzhi.system.model.enums.TenantTypeEnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 租户信息持久层<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Mapper
public interface TenantMapper extends BaseMapper<TenantDO> {

    /**
     * 判断租户名称是否存在
     *
     * @param tenantName 租户名称
     * @param tenantType 租户类型 {@link TenantTypeEnum#getCode()}
     * @param id         租户ID
     * @return 是否存在
     */
    boolean existsTenantByTenantNameAndTenantTypeAndIdNot(@Param("tenantName") String tenantName, @Param("tenantType") String tenantType, @Param("id") String id);

    /**
     * 判断租户编码是否存在
     *
     * @param tenantCode 租户编码
     * @return 是否存在
     */
    boolean existsTenantByTenantCode(@Param("tenantCode") String tenantCode);

    /**
     * 根据ID查询租户信息
     *
     * @param id 租户ID
     * @return 租户信息
     */
    TenantDO queryById(@Param("id") String id);
}
