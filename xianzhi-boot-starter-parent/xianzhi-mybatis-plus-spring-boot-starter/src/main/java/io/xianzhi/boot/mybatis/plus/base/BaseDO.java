package io.xianzhi.boot.mybatis.plus.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.xianzhi.boot.mybatis.plus.MyBatisConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 基础实体<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/16 21:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseDO extends IdDO {



    /**
     * 新增用户
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 新增时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createAt;

    /**
     * 修改用户
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;

    /**
     * 删除标识
     */
    @TableField(value = MyBatisConstant.IS_DELETED)
    private Boolean deletedFlag;
}
