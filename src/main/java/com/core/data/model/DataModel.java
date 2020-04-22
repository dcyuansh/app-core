package com.core.data.model;

import com.core.enums.DataTypeEnum;
import com.core.utils.ConvertUtils;
import com.core.utils.StringUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class DataModel implements Map, Serializable {

    private Map fieldMap;


    public DataModel() {
        fieldMap = new LinkedHashMap<String, Object>();
    }

    public DataModel(Map<String, Object> fieldMap) {
        this.fieldMap = new LinkedHashMap<String, Object>();
        if (fieldMap != null) {
            for (String key : fieldMap.keySet()) {
                this.put(key, fieldMap.get(key), true, false);
            }
        }
    }

    @Override
    public Object put(Object key, Object value) {
        return put(key, value, true, true);
    }

    public Object put(Object key, Object value, boolean needTranslateValue, boolean needFormatFieldName) {
        String name = String.valueOf(key);
        if (needFormatFieldName) {
            name = StringUtils.formatFieldName(name);
        }
        Object resultObject = value;
        if (needTranslateValue) {
            resultObject = StringUtils.translateValue(value);
        }
        fieldMap.put(name, resultObject);
        return resultObject;
    }

    public void setFieldValue(String name, Object value) {
        put(name, value, false, false);
    }

    public Object getFieldValue(String name) {
        return fieldMap.get(name);
    }

    public boolean hasField(String name) {
        return fieldMap.containsKey(name);
    }

    public boolean hasFieldValue(String name) {
        return hasField(name) && getFieldValue(name) != null;
    }

    public void removeField(String name) {
        fieldMap.remove(name);
    }

    public String getStringValue(String name) {
        return (String) ConvertUtils.objectConvert(getFieldValue(name), DataTypeEnum.STRING);
    }

    public Integer getIntegerValue(String name) {
        return (Integer) ConvertUtils.objectConvert(getFieldValue(name), DataTypeEnum.INTEGER);
    }

    public LocalDateTime getLocalDateTimeValue(String name) {
        return (LocalDateTime) ConvertUtils.objectConvert(getFieldValue(name), DataTypeEnum.LOCALDATETIME);
    }

    public LocalDate getLocalDateValue(String name) {
        return (LocalDate) ConvertUtils.objectConvert(getFieldValue(name), DataTypeEnum.LOCALDATE);
    }

    @Override
    public int size() {
        return fieldMap.size();
    }

    @Override
    public boolean isEmpty() {
        return fieldMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return fieldMap.containsValue(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return fieldMap.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return fieldMap.get(key);
    }

    @Override
    public Object remove(Object key) {
        return fieldMap.remove(key);
    }

    @Override
    public void putAll(Map m) {
        fieldMap.putAll(m);
    }

    @Override
    public void clear() {
        fieldMap.clear();
    }

    @Override
    public Set keySet() {
        return fieldMap.keySet();
    }

    @Override
    public Collection values() {
        return fieldMap.values();
    }

    @Override
    public Set<Entry> entrySet() {
        return fieldMap.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataModel dataModel = (DataModel) o;
        return Objects.equals(fieldMap, dataModel.fieldMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldMap);
    }
}
