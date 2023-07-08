package com.enums;

/**
 * 星期枚举实现类
 *
 * @author DC Yuan
 * @since 2020-02-08
 */
public enum WeekEnum implements CodeMessageEnum {

    MONDAY("Monday", "周一"),
    TUESDAY("Tuesday", "周二"),
    WEDNESDAY("Wednesday", "周三"),
    THURSDAY("Thursday", "周四"),
    FRIDAY("Friday", "周五"),
    SATURDAY("Saturday", "周六"),
    SUNDAY("Sunday", "周日"),

    ;

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
