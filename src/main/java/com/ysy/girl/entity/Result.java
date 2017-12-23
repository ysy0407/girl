package com.ysy.girl.entity;

/**
 * 请求返回的最外层信息
 *
 * @author yusongyuan
 * @create 2017-12-23 11:07
 **/

public class Result<T> {

    //编号
    private String code;
    //描述信息
    private String msg;
    //具体内容
    private T date;

    public Result(){}

    public Result(String code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
