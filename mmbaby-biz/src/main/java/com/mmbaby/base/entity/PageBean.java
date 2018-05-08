package com.mmbaby.base.entity;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 9:54
 */
public class PageBean<T> {

    //必须填写的数字
    private Integer pageIndex;      //当前页数

    //必须填写的数字
    private Integer pageSize;       //每页行数

    //根据以上数据计算的结果 limit ${start},${pageSize}
    private Integer start;          //通过指定 当前页数 每页行数,计算开始行

    public void init() {

        if (null == this.pageIndex || null == this.pageSize) {
            this.start = null;
            return;
        }

        if (this.pageIndex < 0 || this.pageSize < 0) {
            this.start = null;
            return;
        }

        //根据当前页计算起始和结束条目
        if (this.pageIndex <= 1) {
            this.start = 0;
        } else {
            this.start = (this.pageIndex - 1) * this.pageSize;
        }
    }

    public static Integer calcPageCount(Long count, Integer pageSize) {
        if (null == count || null == pageSize) {
            return 0;
        }

        if (pageSize.intValue() <= 0) {
            return 0;
        }

        return Long.valueOf((count - 1) / pageSize + 1).intValue();
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
        this.init();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        this.init();
    }

    public Integer getStart() {
        return start;
    }

}