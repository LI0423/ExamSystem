package com.basicsystem.common;

public class ResponseResult {

    public static final String OK_MSG = "ok";
    public static final int OK_CODE = 0;
    // 其他自定义作用成功码
    public static final int OK_CODE_1 = 1;

    public static final String ERR_MSG = "err";
    // 常规异常码
    public static final int ERR_CODE = -1;

    private int code;

    private String msg;

    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseResult(){
        this.code = OK_CODE;
        this.msg = OK_MSG;
        this.data = null;
    }

    public ResponseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult newResultEntity() {
        return newResultEntity(OK_MSG, null);
    }

    public static ResponseResult newResultEntity(Object obj) {
        return newResultEntity(OK_MSG, obj);
    }

    public static ResponseResult newResultEntity(String msg, Object data) {
        return new ResponseResult(OK_CODE, msg, data);
    }

    public static ResponseResult newErrEntity() {
        return newErrEntity(ERR_MSG, null);
    }

    public static ResponseResult newErrEntity(int code, String msg) {
        return new ResponseResult(code, msg, null);
    }

    public static ResponseResult newErrEntity(String msg) {
        return newErrEntity(msg, null);
    }

    public static ResponseResult newErrEntity(String msg, Object data) {
        return new ResponseResult(ERR_CODE, msg, data);
    }
}
