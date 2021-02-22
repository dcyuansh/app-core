package com.core.enums;

/**
 * @author spring
 * @version 1.0
 */
public enum MonthEnum implements CodeMessageEnum {

    January("January", "一月"),
    February("February", "二月"),
    March("March", "三月"),
    April("April", "四月"),
    May("May", "五月"),
    June("June", "六月"),
    July("July", "七月"),
    August("August", "八月"),
    September("September", "九月"),
    October("October", "十月"),
    November("November", "十一月"),
    December("December", "十二月");

    private String code;
    private String message;

    MonthEnum(String code, String message) {
        this.code = code;
        this.message = message;
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
