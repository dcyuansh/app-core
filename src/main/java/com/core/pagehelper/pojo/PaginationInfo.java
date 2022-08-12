package com.core.pagehelper.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Data
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
}
