package com.itcast.mongodb.pojo;

import java.util.List;

/**
 * 分页数据
 */
public class PageResult<T> {
    /**
     * 分页数据
     */
    private List<T> list;
    /**
     * 总数量
     */
    private long total;
    /**
     * 总页数
     */
    private int totalPage;

    public PageResult(List<T> list, long total, int totalPage) {
        this.list = list;
        this.total = total;
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "list=" + list +
                ", total=" + total +
                ", totalPage=" + totalPage +
                '}';
    }
}