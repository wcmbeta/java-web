package com.water.pojo;

import java.util.List;

/**
 * Created by Water on 17/5/25.
 * Email:water471871679@gmail.com
 */
public class PageBean {
    /**
     * 当前页数
     */
    private Integer currentPage;
    /**
     * 总条数
     */
    private Integer totalCount;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 分页列表数据
     */
    private List list;

    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        if (this.currentPage == null) {
            this.currentPage = 1;
        }
        if (this.pageSize == null) {
            this.pageSize = 3;
        }
        if (this.totalCount == null) {
            this.totalCount = 1;
        }
        //总页数
        this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;

        //判断页数是否超出范围
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
        if (this.currentPage > this.totalPage) {
            this.currentPage = this.totalPage;
        }
    }

    public Integer getStart(){
        return  (this.currentPage - 1) * this.pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

}

