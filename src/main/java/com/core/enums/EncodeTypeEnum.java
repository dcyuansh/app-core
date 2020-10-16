package com.core.enums;


/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum EncodeTypeEnum implements CodeEnum {

    UTF8("UTF-8"), GBK("GBK"), GB2312("GB2312"), ISO88591("ISO-8859-1"), ASCII("ASCII");

    private String code;

    EncodeTypeEnum(String code) {
        this.code = code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
