package com.core.utils;

import com.core.enums.DataTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class ConvertUtils {


    /****
     * object convert others
     * @param obj
     * @param dataType
     * @return
     */
    public static Object objectConvert(Object obj, DataTypeEnum dataType) {
        Object objResult = null;
        if (obj == null) return null;
        try {
            switch (dataType) {
                case STRING:
                    objResult = obj.toString();
                    break;
                case BYTE:
                    if (obj instanceof Byte) {
                        objResult = (Byte) obj;
                    } else {
                        objResult = obj.toString().getBytes();
                    }
                    break;
                case CHAR:
                    if (obj instanceof Character) {
                        objResult = (Character) obj;
                    } else {
                        objResult = obj.toString().toCharArray();
                    }
                    break;
                case SHORT:
                    if (obj instanceof Short) {
                        objResult = (Short) obj;
                    } else {
                        objResult = Short.parseShort(obj.toString());
                    }
                    break;
                case INTEGER:
                    if (obj instanceof Integer) {
                        objResult = ((Integer) obj).intValue();
                    } else {
                        objResult = Integer.parseInt(obj.toString());
                    }
                    break;
                case LONG:
                    if (obj instanceof Long) {
                        objResult = ((Long) obj).longValue();
                    } else {
                        objResult = Long.parseLong(obj.toString());
                    }
                    break;
                case FLOAT:
                    if (obj instanceof Float) {
                        objResult = ((Float) obj).floatValue();
                    } else {
                        objResult = Float.parseFloat(obj.toString());
                    }
                    break;
                case DOUBLE:
                    if (obj instanceof Double) {
                        objResult = ((Double) obj).doubleValue();
                    } else {
                        objResult = Double.parseDouble(obj.toString());
                    }
                    break;
                case BIGDECIMAL:
                    if (obj instanceof BigDecimal) {
                        objResult = (BigDecimal) obj;
                    } else {
                        objResult = new BigDecimal(obj.toString());
                    }
                    break;
                case LOCALTIME:
                    if (obj instanceof LocalTime) {
                        objResult = (LocalTime) obj;
                    } else {
                        objResult = null;
                    }
                    break;
                case LOCALDATE:
                    if (obj instanceof LocalDate) {
                        objResult = (LocalDate) obj;
                    } else {
                        objResult = LocalDateUtils.formatDate(obj.toString(), null);
                    }
                    break;
                case LOCALDATETIME:
                    if (obj instanceof LocalDateTime) {
                        objResult = (LocalDateTime) obj;
                    } else {
                        objResult = LocalDateTimeUtils.formatTime(obj.toString(), null);
                    }
                    break;
                case BOOLEAN:
                    if (obj instanceof Boolean) {
                        objResult = (Boolean) obj;
                    } else {
                        objResult = Boolean.valueOf(obj.toString());
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objResult;
    }
}
