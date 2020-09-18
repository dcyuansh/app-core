package com.core.enums;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum WeekEnum implements CodeMessageEnum {

    Monday("Monday", "周一"),
    Tuesday("Tuesday", "周二"),
    Wednesday("Wednesday", "周三"),
    Thursday("Thursday", "周四"),
    Friday("Friday", "周五"),
    Saturday("Saturday", "周六"),
    Sunday("Sunday", "周日");

    private String code;
    private String message;

    WeekEnum(String code, String msg) {
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
