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

package io.xianzhi.boot.mybatis.plus;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.xianzhi.core.context.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 自定义填充审计信息<br>
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
public class CustomMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        DateTime now = DateUtil.date();
        String currentUserId = UserContext.getCurrentUserId();
        this.setFieldValByName(MyBatisConstant.CREATE_BY, currentUserId, metaObject);
        this.setFieldValByName(MyBatisConstant.UPDATE_BY, currentUserId, metaObject);
        this.setFieldValByName(MyBatisConstant.CREATE_AT, now, metaObject);
        this.setFieldValByName(MyBatisConstant.UPDATE_AT, now, metaObject);
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName(MyBatisConstant.UPDATE_BY, UserContext.getCurrentUserId(), metaObject);
        this.setFieldValByName(MyBatisConstant.UPDATE_AT, DateUtil.date(), metaObject);

    }
}
