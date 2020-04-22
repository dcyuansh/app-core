package com.core.enums;


/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum EncodeTypeEnum {

    UTF8("UTF-8"), GBK("GBK"), GB2312("GB2312"), ISO88591("ISO-8859-1"), ASCII("ASCII");

    private String encodeType;

    EncodeTypeEnum(String encodeType) {
        this.encodeType = encodeType;
    }

    public String getEncodeType() {
        return encodeType;
    }

    public void setEncodeType(String encodeType) {
        this.encodeType = encodeType;
    }
}
