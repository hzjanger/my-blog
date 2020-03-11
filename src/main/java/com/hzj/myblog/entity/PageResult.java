package com.hzj.myblog.entity;

import java.util.List;

/**
 * 分页结果实体
 *
 * @author hzj
 */
public class PageResult<T> {
    /**
     * 分页的总页数
     */
    private Long total;
    /**
     * 分页结果
     */
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
