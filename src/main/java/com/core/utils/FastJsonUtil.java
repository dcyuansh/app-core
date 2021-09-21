package com.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class FastJsonUtil {

    /**
     * @param object
     * @return
     * @desc object to json
     */
    public static JSON objToJson(Object object) {
        JSON resultJson = null;
        if (object != null) {
            resultJson = JSON.parseObject(JSON.toJSONString(object));
        }
        return resultJson;
    }


    /**
     * @param object
     * @param excludeKeys
     * @return
     * @desc object to json exclude keys
     */
    public static JSON objToJson(Object object, String... excludeKeys) {
        JSON resultJson = null;
        if (object != null && excludeKeys != null) {
            List<String> excludes = Arrays.asList(excludeKeys);
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
            filter.getExcludes().addAll(excludes);    //重点！！！
            resultJson = JSON.parseObject(JSON.toJSONString(object, filter));
        }
        return resultJson;
    }


    /**
     * @param object
     * @param excludeKeys
     * @return
     * @desc object to json exclude list key
     */
    public static JSON objToJson(Object object, List<String> excludeKeys) {
        JSON resultJson = null;
        if (object != null && excludeKeys != null) {
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
            filter.getExcludes().addAll(excludeKeys);    //重点！！！
            resultJson = JSON.parseObject(JSON.toJSONString(object, filter));
        }
        return resultJson;
    }


    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @desc json to object
     */
    public static <T> T jsonToObj(String json, Class<T> clazz) {
        T object = null;
        if (json != null) {
            object = JSON.parseObject(json, clazz);
        }
        return object;
    }
}


