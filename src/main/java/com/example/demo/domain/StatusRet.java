package com.example.demo.domain;

public class StatusRet {

    private String code;
    private String errMsg;
    private Object t;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getT() {
        return t;
    }

    public void setT(Object t) {
        this.t = t;
    }

    public StatusRet(String code, String errMsg, Object t) {
        this.code = code;
        this.errMsg = errMsg;
        this.t = t;
    }
}
