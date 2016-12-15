package com.nosql.util;


import java.util.List;

/**
 * 设置公共的分页类
 *
 * @param <T>
 */
public class Pager<T> {
    private int pageSize;
    private int pageNow;
    private int pageCount;
    private int rowCount;
    private List<T> data;

    public Pager() {

    }

    public Pager(int pageSize, int pageNow, int pageCount, int rowCount, List<T> data) {
        this.pageSize = pageSize;
        this.pageNow = pageNow;
        this.pageCount = pageCount;
        this.rowCount = rowCount;
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
