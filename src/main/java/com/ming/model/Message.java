package com.ming.model;

import java.util.List;
import java.util.Map;

/**
 * 返回信息
 */
public class Message {

    private int code;

    private String message;

    private Map<String,Object> resultData;

    public Message() {
    }

    public Message(int code, String message, Map<String, Object> resultData) {
        this.code = code;
        this.message = message;
        this.resultData = resultData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResultData() {
        return resultData;
    }

    public void setResultData(Map<String, Object> resultData) {
        this.resultData = resultData;
    }
}
