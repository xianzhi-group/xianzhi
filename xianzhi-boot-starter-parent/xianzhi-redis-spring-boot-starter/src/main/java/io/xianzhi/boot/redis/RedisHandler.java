/*
 * Copyright (c) 2023-2023  XianZhi Group (team@xianzhi.io) All Rights
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

package io.xianzhi.boot.redis;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存处理<br>
 *
 * @author Max
 * @since 1.0.0
 */
public class RedisHandler {
    /**
     * redisTemplate
     */
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置一个缓存
     *
     * @param key 缓存的key
     * @param obj 缓存的值
     */
    public void valueSet(String key, Object obj) {
        valueSet(key, obj, 0L);
    }

    /**
     * 设置一个缓存，并设置过期时间，单位是秒
     *
     * @param key  缓存的key
     * @param obj  缓存的值
     * @param time 过期时间
     */
    public void valueSet(String key, Object obj, Long time) {
        valueSet(key, obj, time, TimeUnit.SECONDS);
    }

    /**
     * 设置一个缓存，并设置过期时间，同时制定过期时间单位
     *
     * @param key      缓存的key
     * @param obj      缓存的值
     * @param time     过期时间
     * @param timeUnit 过期时间单位
     */
    public void valueSet(String key, Object obj, Long time, TimeUnit timeUnit) {
        if (null == time || time <= 0) {
            redisTemplate.opsForValue().set(key, obj);
        } else {
            redisTemplate.opsForValue().set(key, obj, time, timeUnit);
        }
    }

    /**
     * 获取一个缓存
     *
     * @param key 缓存的key
     * @return 缓存信息
     */
    public Object valueGet(String key) {
        if (StringUtils.hasText(key)) {
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    /**
     * 获取一个缓存
     *
     * @param key    缓存的key
     * @param tClass 返回类型
     * @param <T>    缓存的泛型
     * @return 缓存
     */
    public <T> T valueGet(String key, Class<T> tClass) {
        return BeanUtil.read(valueGet(key), tClass);
    }


    public <T> List<T> valueGetList(String key, Class<T> tClass) {
        return BeanUtil.readList(valueGet(key), tClass);
    }

    /**
     * 将key设置过期
     *
     * @param key 缓存的key
     */
    public void expire(String key) {
        expire(key, null);

    }

    /**
     * 设置过期时间，单位是秒
     *
     * @param key  需要设置过期时间的key
     * @param time 过期时间
     */
    public void expire(String key, Long time) {
        expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 设置过期时间，同时指定单位
     *
     * @param key      需要设置过期时间的key
     * @param time     过期时间
     * @param timeUnit 过期时间单位
     */
    public void expire(String key, Long time, TimeUnit timeUnit) {
        if (StringUtils.hasText(key)) {
            if (null == time || time <= 0) {
                redisTemplate.expire(key, 0, TimeUnit.SECONDS);
            } else {
                redisTemplate.expire(key, time, timeUnit);
            }
        }
    }

    /**
     * 删除缓存
     *
     * @param key 缓存的key
     */
    public void deleted(String key) {
        if (StringUtils.hasText(key)) {
            redisTemplate.delete(key);
        }
    }
}
