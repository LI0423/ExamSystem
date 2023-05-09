package com.basicsystem.common;

public class ResponseResultPage extends ResponseResult {

    private Long total;

    public ResponseResultPage(Long count) {
        this.total = count;
    }

    public ResponseResultPage(Integer code, String msg, Object data, Long count) {
        super(code, msg, data);
        this.total = count;
    }

    public static ResponseResultPage newResultEntityPage(Integer code, String msg, Object data, Long count) {
        return new ResponseResultPage(code, msg, data, count);
    }

    public static ResponseResultPage newResultEntityPage(Integer code, String msg, Object data) {
        return new ResponseResultPage(code, msg, data, null);
    }

    public static ResponseResultPage newResultEntityPage(ResponseResult res) {
        return new ResponseResultPage(res.getCode(), res.getMsg(), res.getData(), null);
    }


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
