package com.dxy.zidane.common.web.response;

/**
 * @author dxy
 * @date 2019/11/15 18:07
 */
public enum CodeEnum {
    /**
     *
     */
    SUCCESS(200000, "成功"),

    /**
     *
     */
    INVALID_PARAM(100000, "参数校验错误"),

    /**
     *
     */
    UNKNOW_ERROR(300000, "未知错误"),

    /**
     *
     */
    INTERNAL_ERROR(500000, "服务器内部错误");


    private final Integer code;
    private final String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
