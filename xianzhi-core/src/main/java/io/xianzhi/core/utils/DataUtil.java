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

package io.xianzhi.core.utils;

import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * data 工具类<br>
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
public class DataUtil {

    /**
     * 将对象转换为指定的类型
     *
     * @param obj    需要转换的对象
     * @param tClass 指定类型的泛型
     * @param <T>    泛型
     * @return 泛型对象
     */
    public static <T> T read(Object obj, Class<T> tClass) {
        if (null != obj) {
            try {
                T newInstance = tClass.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(obj, newInstance);
                return newInstance;
            } catch (Exception exception) {
                log.error(exception.getMessage(), exception);
                throw new BizException(CommonCode.ERROR);
            }
        }
        return null;
    }

    /**
     * 转换集合或者数组对象到指定类型
     *
     * @param obj    需要转换的数组或者集合
     * @param tClass 需要转换的类型
     * @param <T>    泛型
     * @return 转换指定类型的对象
     */
    public static <T> List<T> readList(Object obj, Class<T> tClass) {
        List<T> list = new ArrayList<>();
        if (ObjectUtils.isArray(obj)) {
            Object[] dataList = (Object[]) obj;
            for (Object data : dataList) {
                list.add(read(data, tClass));
            }
        } else if (obj instanceof List<?>) {
            ((List<?>) obj).forEach(data -> {
                list.add(read(data, tClass));
            });

        } else {
            throw new BizException(CommonCode.OBJECT_TYPE_ERROR);
        }
        return list;
    }

}
