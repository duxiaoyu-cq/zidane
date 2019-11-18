package com.dxy.zidane.common.web.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author dxy
 * @date 2019/11/17 10:54
 */
public class JSONResponse<T> {
    protected CodeEnum code;
    protected String message;
    protected T data;

    private JSONResponse() {

    }

    public static JSONResponse build() {
        return new JSONResponse();
    }

    public JSONResponse successful(T data) {
        this.code = CodeEnum.SUCCESS;
        this.data = data;
        return this;
    }

    public JSONResponse successful(T data, String message) {
        this.code = CodeEnum.SUCCESS;
        this.data = data;
        this.message = message;
        return this;
    }

    public JSONResponse failure(CodeEnum code) {
        this.code = code;
        this.message = this.code.getMessage();
        return this;
    }

    public JSONResponse failure(String message) {
        this.code = CodeEnum.UNKNOW_ERROR;
        this.message = message;
        return this;
    }

    public JSONResponse failure(CodeEnum code, String message, T data) {
        this.code = code;
        this.data = data;
        this.message = (message == null ? code.getMessage() : message);
        return this;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
