package com.core.enums;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum ResultEnum {

    RESULT_STATUS("status"), RESULT_CODE("code"), RESULT_DATA("data"), RESULT_MESSAGE("msg");

    private String resultType;

    ResultEnum(String resultType) {
        this.resultType = resultType;
    }

    public String getresultType() {
        return resultType;
    }

    public void setresultType(String resultType) {
        this.resultType = resultType;
    }
}
