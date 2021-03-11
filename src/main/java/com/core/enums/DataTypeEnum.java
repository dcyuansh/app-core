package com.core.enums;

/**
 * @author spring.yuan
 * @version 1.0
 */
public enum DataTypeEnum {

    STRING, BYTE, CHAR, SHORT, INTEGER, LONG, FLOAT, DOUBLE, BIGDECIMAL, LOCALTIME, LOCALDATE, LOCALDATETIME, BOOLEAN;

    public boolean isString() {
        return this.equals(DataTypeEnum.STRING);
    }

    public boolean isByte() {
        return this.equals(DataTypeEnum.BYTE);
    }

    public boolean isChar() {
        return this.equals(DataTypeEnum.CHAR);
    }

    public boolean isShort() {
        return this.equals(DataTypeEnum.SHORT);
    }

    public boolean isInteger() {
        return this.equals(DataTypeEnum.INTEGER);
    }

    public boolean isLong() {
        return this.equals(DataTypeEnum.LONG);
    }

    public boolean isFloat() {
        return this.equals(DataTypeEnum.FLOAT);
    }

    public boolean isDouble() {
        return this.equals(DataTypeEnum.DOUBLE);
    }

    public boolean isBigDecimal() {
        return this.equals(DataTypeEnum.BIGDECIMAL);
    }

    public boolean isLocalTime() {
        return this.equals(DataTypeEnum.LOCALTIME);
    }

    public boolean isLocalDate() {
        return this.equals(DataTypeEnum.LOCALDATE);
    }

    public boolean isLocalDateTime() {
        return this.equals(DataTypeEnum.LOCALDATETIME);
    }

    public boolean isBoolean() {
        return this.equals(DataTypeEnum.BOOLEAN);
    }

    public static DataTypeEnum getInstance(String dataType) {
        DataTypeEnum result = null;
        try {
            result = DataTypeEnum.valueOf(dataType.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date type:'" + dataType
                    + "'");
        }
        return result;
    }
}
