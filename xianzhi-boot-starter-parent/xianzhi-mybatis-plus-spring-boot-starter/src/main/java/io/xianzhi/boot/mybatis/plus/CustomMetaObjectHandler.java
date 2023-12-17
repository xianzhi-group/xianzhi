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
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/16 21:28
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
