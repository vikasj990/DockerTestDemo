package com.iceye.sbdb.api;

public enum StatusCode {
    CODE_200(200, ""),
    CODE_201(201, ""),
    CODE_400(400, "Missing required field: name"),
    CODE_401(401, "Invalid access token"),
    CODE_405(405,"Method Not Allowed"),
    CODE_500(500, "Internal Server Error"),
    CODE_503(503, "Service Unavailable");

    public final int code;
    public final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

/*    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }*/
}
