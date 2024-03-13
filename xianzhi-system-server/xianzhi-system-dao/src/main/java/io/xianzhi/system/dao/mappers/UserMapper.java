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

package io.xianzhi.system.dao.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.system.dao.dataobj.UserDO;
import io.xianzhi.system.model.vo.AuthUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息持久层<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {


    /**
     * 根据用户类型查询用户列表
     *
     * @param userType 用户类型
     * @return 用户列表
     */
    List<UserDO> getUserByUserType(@Param("userType") String userType);


    /**
     * 搜索系统用户列表
     *
     * @param key 关键字，昵称，真实姓名，工号
     * @return 用户信息
     */
    List<UserDO> adminSearch(String key);

    /**
     * 根据用户名和用户类型加载用户信息
     *
     * @param username 用户名
     * @param userType 用户类型
     * @return 用户信息
     */
    AuthUserVO loadAuthUserByUsernameAndUserType(@Param("username") String username, @Param("userType") String userType);
}
