package com.dxy.zidane.common.web;

/**
 * @author dxy
 * @date 2019/11/15 18:07
 */
public enum ResponseCodeEnum {
    SUCCESS("200000", "SUCCESS"),
    INVALID_PARAM("100000", "参数校验错误"),
    UNKNOW_ERROR("300000", "未知错误"),
    INTERNAL_ERROR("500000", "服务器内部错误"),
    ;
    private final String code;
    private final String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
