package com.core.enums;

import com.core.utils.EnumUtil;

/**
 * @author spring
 * @version 1.0
 */
public enum ContentTypeMessageEnum implements CodeEnum {

    JSON("application/json"), XML("application/xml"), XWWWFORMURLENCODEED("application/x-www-form-urlencoded"), MULTIPART("multipart/form-data"), XMLRPC("text/xml"), UNDEFINED("undefined");

    private String code;


    ContentTypeMessageEnum(String code) {
        this.code = code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }


    public boolean isJson() {
        return this.equals(ContentTypeMessageEnum.JSON);
    }

    public boolean isXml() {
        return this.equals(ContentTypeMessageEnum.XML);
    }

    public boolean isXmlRPC() {
        return this.equals(ContentTypeMessageEnum.XMLRPC);
    }

    public boolean isMultipart() {
        return this.equals(ContentTypeMessageEnum.MULTIPART);
    }

    public boolean isXwwwformUrlEncodeed() {
        return this.equals(ContentTypeMessageEnum.XWWWFORMURLENCODEED);
    }

    public static ContentTypeMessageEnum getInstance(String contentTypeValue) {
        ContentTypeMessageEnum result = null;
        try {
            result = EnumUtil.getEnumByCd(contentTypeValue, ContentTypeMessageEnum.class);
        } catch (Exception e) {
            result = ContentTypeMessageEnum.UNDEFINED;
        }
        return result;
    }
}
