package com.kmxy.utils;

import java.util.List;

public class PageBean<T> {
    private List<T> records;//当前页显示的数据
    private long pageNum;    //当前页码
    private long totalPageNum;    //总页码

    private long pageSize = Const.PAGE_SIZE;    //每页显示的记录条数
    private long totalRecordsNum;    //总记录条数

    private long prePageNum;    //上一页
    private long nextPageNum;    //下一页
    private long startIndex;    //每页开始记录的索引

    private String url;    //查询分页的请求的地址(通过这个属性可以将页面中的分页部分给抽取成公共部分)

    public PageBean() {

    }

    public PageBean(long pageNum, long pageSize, long totalRecordsNum) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecordsNum = totalRecordsNum;

        //计算总页码
        totalPageNum = totalRecordsNum % pageSize == 0 ? totalRecordsNum / pageSize : (totalRecordsNum / pageSize + 1);
        startIndex = (pageNum - 1) * pageSize;   //计算开始记录的索引
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(long totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public long getPrePageNum() {
        prePageNum = pageNum - 1;
        if (prePageNum < 1) {
            prePageNum = 1;
        }
        return prePageNum;
    }

    public void setPrePageNum(long prePageNum) {
        this.prePageNum = prePageNum;
    }

    public long getNextPageNum() {
        nextPageNum = pageNum + 1;
        if (nextPageNum > totalPageNum) {
            nextPageNum = totalPageNum;
        }
        return nextPageNum;
    }

    public void setNextPageNum(long nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecordsNum() {
        return totalRecordsNum;
    }

    public void setTotalRecordsNum(long totalRecordsNum) {
        this.totalRecordsNum = totalRecordsNum;
    }

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "records=" + records +
                ", pageNum=" + pageNum +
                ", totalPageNum=" + totalPageNum +
                ", pageSize=" + pageSize +
                ", totalRecordsNum=" + totalRecordsNum +
                ", prePageNum=" + prePageNum +
                ", nextPageNum=" + nextPageNum +
                ", startIndex=" + startIndex +
                ", url='" + url + '\'' +
                '}';
    }
}