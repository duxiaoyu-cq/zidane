package com.dxy.zidane.common.web;

/**
 * @author dxy
 * @date 2019/11/15 18:00
 */
public class FailureResponse<T> extends Response {

    public FailureResponse(String code, T data, String message) {
        super.code = code;
        super.data = data;
        super.message = message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
