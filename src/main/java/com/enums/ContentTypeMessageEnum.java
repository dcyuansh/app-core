package com.enums;

import com.utils.EnumUtil;

/**
 * content type枚举实现类
 *
 * @author DC Yuan
 * @since 2020-02-08
 */
public enum ContentTypeMessageEnum implements CodeEnum {

    JSON("application/json"),
    XML("application/xml"),
    MULTIPART("multipart/form-data"),
    UNDEFINED("undefined"),

    ;

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


    public boolean isMultipart() {
        return this.equals(ContentTypeMessageEnum.MULTIPART);
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
