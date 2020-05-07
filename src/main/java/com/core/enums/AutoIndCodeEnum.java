package com.core.enums;


/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum AutoIndCodeEnum implements CodeMessageEnum {
    Y("AUTO", "自动执行"), N("MANUAL", "手动执行");

    private String code;
    private String message;

    AutoIndCodeEnum(String code, String msg) {
        this.code = code;
        this.message = msg;
    }


    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
