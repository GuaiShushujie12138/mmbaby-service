package com.mmbaby.base.util;

import lombok.ToString;

import java.io.Serializable;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/20 at 17:20
 */

@ToString
public class PageUtil implements Serializable {

    private static final long serialVersionUID = 585948611115134017L;

    private Integer pageIndex;

    private Integer pageSize;

    private Integer start;

    // 排序条件
    private String sort;

    // 搜索关键字
    private String keyWord;

    public PageUtil(Integer pageIndex, Integer pageSize) {
        if (pageIndex <= 0) {
            pageIndex = 1;
        }

        if (pageSize <= 0 || pageSize > 10) {
            pageSize = 10;
        }

        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.start = (pageIndex - 1) * pageSize + 1;
    }

    public PageUtil() {
        this.pageIndex = 1;
        this.pageSize = 10;
        this.start = 1;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
