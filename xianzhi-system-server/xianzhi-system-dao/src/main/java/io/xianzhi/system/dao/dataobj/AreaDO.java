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

package io.xianzhi.system.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import io.xianzhi.boot.mybatis.plus.base.IdDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 区 实体<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Data
@TableName(value = "xz_area")
@EqualsAndHashCode(callSuper = true)
public class AreaDO extends IdDO {
    /**
     * 区名称
     */
    private String areaName;


    /**
     * 市Id
     */
    private String cityId;

    /**
     * 省Id
     */
    private String provincialId;
}