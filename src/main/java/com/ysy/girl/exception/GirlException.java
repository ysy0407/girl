package com.ysy.girl.exception;

/**
 * 自定义异常
 *
 * @author yusongyuan
 * @create 2017-12-23 15:11
 **/

public class GirlException extends RuntimeException {

    private String code;

    public GirlException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
