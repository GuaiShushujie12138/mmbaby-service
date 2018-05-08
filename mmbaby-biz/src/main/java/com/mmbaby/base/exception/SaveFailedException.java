package com.mmbaby.base.exception;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 9:57
 */
public class SaveFailedException extends RuntimeException {

    public SaveFailedException() {
    }

    public SaveFailedException(String message) {
        super(message);
    }

    public SaveFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveFailedException(Throwable cause) {
        super(cause);
    }

    public SaveFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
