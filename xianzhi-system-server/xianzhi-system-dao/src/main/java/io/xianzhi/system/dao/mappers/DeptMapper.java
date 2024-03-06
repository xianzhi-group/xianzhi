package io.xianzhi.system.dao.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.system.dao.dataobj.DeptDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 部门信息持久层<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Mapper
public interface DeptMapper extends BaseMapper<DeptDO> {
}
