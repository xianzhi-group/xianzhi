package io.xianzhi.core.base;

import lombok.Data;

/**
 * 基础分页查询条件<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/15 19:21
 */
@Data
public class Page {

    /**
     * 当前页码
     */
    private Integer pageNo;

    /**
     * 每页展示条数
     */
    private Integer pageSize;
}
