package com.utils.converter;

import com.utils.LocalDateUtils;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author DC Yuan
 * @since 2020-02-08
 */
public class LocalDateConverter {

    public static Object convert(Class targetType, Object inputValue, Object nullValue) {
        Object convertedValue = null;
        if (LocalDate.class.isAssignableFrom(targetType)) {
            if (inputValue instanceof LocalDate) {
                convertedValue = inputValue;
            } else if (inputValue == null
                    || inputValue.toString().equalsIgnoreCase("")) {
                convertedValue = nullValue;
            } else {
                convertedValue = LocalDateUtils.formatDate(inputValue.toString(), null);
            }
        } else {
            throw new IllegalArgumentException("LocalDate convert exception");
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
