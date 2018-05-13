package com.mmbaby.base.util;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 10:58
 *
 * 基础失败返回对象
 */
public class ErrorResult extends GeneralResult {

    private static int code = -1;

    private static String errMsg = "操作失败";

    public ErrorResult(String errMsg) {
        super(code, errMsg);
    }

    public ErrorResult() {
        super(code, errMsg);
    }

    @Override
    public boolean isSuccess() {
        return false;
    }
}
