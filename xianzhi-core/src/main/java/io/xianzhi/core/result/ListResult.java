package io.xianzhi.core.result;

import lombok.Data;

import java.util.List;

/**
 * 列表返回结果<br>
 *
 * @author Max  <a href="mailto:max@xianzhi.io">max@xianzhi.io</a>
 * @version 1.0.0
 * @since 2023/12/15 19:43
 */
@Data
public class ListResult<T> {

    /**
     * 查询的列表数据
     */
    private List<T> list;

    /**
     * 查询的总数
     */
    private long total;
}
