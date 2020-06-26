package com.core.enums;

import com.core.utils.EnumUtil;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum AcceptMessageEnum implements CodeEnum {

    JSON("application/json"), XML("application/xml"), XWWWFORMURLENCODEED("application/x-www-form-urlencoded"), MULTIPART("multipart/form-data"), XMLRPC("text/xml"), UNDEFINED("undefined");

    private String acceptValue;


    AcceptMessageEnum(String contentTypeValue) {
        this.acceptValue = contentTypeValue;
    }

    @Override
    public void setCode(String code) {
        this.acceptValue = code;
    }

    @Override
    public String getCode() {
        return acceptValue;
    }


    public boolean isJson() {
        return this.equals(AcceptMessageEnum.JSON);
    }

    public boolean isXml() {
        return this.equals(AcceptMessageEnum.XML);
    }

    public boolean isXmlRPC() {
        return this.equals(AcceptMessageEnum.XMLRPC);
    }

    public boolean isMultipart() {
        return this.equals(AcceptMessageEnum.MULTIPART);
    }

    public boolean isXwwwformUrlEncodeed() {
        return this.equals(AcceptMessageEnum.XWWWFORMURLENCODEED);
    }

    public static AcceptMessageEnum getInstance(String contentTypeValue) {
        AcceptMessageEnum result = null;
        try {
            result = EnumUtil.getEnumByCd(contentTypeValue, AcceptMessageEnum.class);
        } catch (Exception e) {
            result = AcceptMessageEnum.UNDEFINED;
        }
        return result;
    }
}
