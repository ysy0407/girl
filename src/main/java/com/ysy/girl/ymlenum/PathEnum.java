package com.ysy.girl.ymlenum;

public enum PathEnum {

    RESULT("girl.vail.");

    private String path;

    @Override
    public String toString() {
        return "PathEnum{" +
                "path='" + path + '\'' +
                '}';
    }

    PathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
