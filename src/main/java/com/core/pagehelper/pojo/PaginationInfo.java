package com.core.pagehelper.pojo;

import java.util.List;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class PaginationInfo<T> {

    /**
     * 当前页数
     */
    private int pageNum;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 数据库查询结果集
     */
    private List<T> data;

    /**
     * @param obj    继承了PaginationInfo的类
     * @param result 从数据库中查询出来的结果
     * @return
     */
    public PaginationInfo getPaginationInfo(PaginationInfo obj, List<T> result) {
        PaginationInfo<T> paginationInfo = new PaginationInfo<>();
        paginationInfo.setPageNum(obj.getPageNum());
        paginationInfo.setPageSize(obj.getPageSize());
        paginationInfo.setPages(obj.getPages());
        paginationInfo.setTotal(obj.getTotal());
        paginationInfo.setData(result);
        return paginationInfo;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
