package com.ysy.girl.ymlenum;

/**
 * 错误枚举
 *
 * @author yusongyuan
 * @create 2017-12-23 15:53
 **/

public enum ErrEnum {

    UNKNOW_ERROR("err-9999", "未知错误");

    private String code;
    private String msg;

    ErrEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
