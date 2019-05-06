package com.mmbaby.base.util;

import com.google.common.base.MoreObjects;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 10:04
 *
 * 基础返回对象
 */

@ToString
public class GeneralResult<T> implements Serializable {

    private T data;

    protected int code = 0;

    protected String msg = "操作成功";

    public GeneralResult() {}

    public GeneralResult(T data) {
        this.data = data;
    }

    public GeneralResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GeneralResult returnFaile(String errMsg) {
        return new ErrorResult(errMsg);
    }

    public boolean isSuccess() {
        return code == 0;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
