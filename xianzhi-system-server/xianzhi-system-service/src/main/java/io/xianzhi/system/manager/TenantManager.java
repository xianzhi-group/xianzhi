package io.xianzhi.system.manager;

import io.xianzhi.boot.redis.RedisHandler;
import io.xianzhi.system.constants.SystemCacheKeyConstant;
import io.xianzhi.system.dao.dataobj.TenantDO;
import io.xianzhi.system.dao.mappers.TenantMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * 租户管理<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TenantManager {

    /**
     * Redis操作
     */
    private final RedisHandler redisHandler;

    /**
     * 租户信息持久层
     */
    private final TenantMapper tenantMapper;

    /**
     * 根据租户ID查询租户信息<br>
     *
     * @param id 租户ID
     * @return 租户信息
     */
    public TenantDO getTenantById(String id) {
        if (StringUtils.hasText(id)) {
            String key = String.format(SystemCacheKeyConstant.TENANT_BY_ID, id);
            TenantDO tenantDO = redisHandler.valueGet(key, TenantDO.class);
            if (null == tenantDO) {
                tenantDO = tenantMapper.queryById(id);
                if (null == tenantDO) {
                    redisHandler.valueSet(key, new TenantDO(), 20L, TimeUnit.SECONDS);
                    return null;
                }
            }
            return StringUtils.hasText(tenantDO.getId()) ? tenantDO : null;
        }
        log.error("根据租户ID查询租户信息失败,租户ID为空");
        return null;

    }
}