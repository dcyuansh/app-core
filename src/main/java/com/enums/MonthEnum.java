package com.enums;

/**
 * @author DC Yuan
 *  @since 2020-02-08
 */
public enum MonthEnum implements CodeMessageEnum {

    JANUARY("January", "一月"),
    FEBRUARY("February", "二月"),
    MARCH("March", "三月"),
    APRIL("April", "四月"),
    MAY("May", "五月"),
    JUNE("June", "六月"),
    JULY("July", "七月"),
    AUGUST("August", "八月"),
    SEPTEMBER("September", "九月"),
    OCTOBER("October", "十月"),
    NOVEMBER("November", "十一月"),
    DECEMBER("December", "十二月"),

    ;

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
