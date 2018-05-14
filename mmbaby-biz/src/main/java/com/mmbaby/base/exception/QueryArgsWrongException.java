package com.mmbaby.base.exception;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 16:10
 */
public class QueryArgsWrongException extends RuntimeException {

    public QueryArgsWrongException() {
    }

    public QueryArgsWrongException(String message) {
        super(message);
    }

    public QueryArgsWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueryArgsWrongException(Throwable cause) {
        super(cause);
    }

    public QueryArgsWrongException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
