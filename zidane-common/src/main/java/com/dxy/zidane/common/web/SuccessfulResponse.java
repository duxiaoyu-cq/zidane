package com.dxy.zidane.common.web;

/**
 * @author dxy
 * @date 2019/11/15 18:00
 */
public class SuccessfulResponse<T> extends Response {

    public SuccessfulResponse(T data) {
        super.code = "200000";
        super.data = data;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
