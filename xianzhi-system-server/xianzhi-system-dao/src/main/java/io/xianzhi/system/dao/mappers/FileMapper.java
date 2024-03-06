package io.xianzhi.system.dao.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.system.dao.dataobj.FileDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件信息实体<br>
 *
 * @author Ethan Wang
 * @since 1.0.0
 */
@Mapper
public interface FileMapper extends BaseMapper<FileDO> {
}
