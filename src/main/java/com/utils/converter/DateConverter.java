package com.utils.converter;

import com.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author DC Yuan
 * @since 2020-02-08
 */
public class DateConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (Date.class.isAssignableFrom(targetType)) {
            if (inputValue instanceof Date) {
                convertedValue = inputValue;
            } else if (inputValue instanceof Calendar) {
                convertedValue = ((Calendar) inputValue).getTime();
            } else if (inputValue instanceof Number) {
                convertedValue = new Date(((Number) inputValue).longValue());
            } else if (inputValue == null
                    || inputValue.toString().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = DateUtils.formatDate(inputValue.toString(), null);
            }
        } else {
            throw new IllegalArgumentException("Date convert exception");
        }
        return convertedValue;
    }

    public static Object convert(Object inputValue, Object nullValue) {
        return convert(getDefaultTargetType(), inputValue, nullValue);
    }

    public static Object convert(Object inputValue) {
        return convert(inputValue, null);
    }

    public static Class getDefaultTargetType() {
        return Date.class;
    }
}
