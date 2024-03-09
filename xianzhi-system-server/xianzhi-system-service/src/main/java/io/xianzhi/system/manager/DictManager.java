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

package io.xianzhi.system.manager;

import io.xianzhi.boot.redis.RedisHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 字典管理<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DictManager {
    /**
     * redis操作
     */
    private final RedisHandler redisHandler;


    /**
     * 判断字典项是否存在<br>
     *
     * @param id       字典项ID
     * @param dictCode 字典编码
     * @return 是否存在
     */
    public boolean existsItemById(String id, String dictCode) {
        return false;
    }


}
