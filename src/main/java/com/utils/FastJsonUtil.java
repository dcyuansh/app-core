package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @author DC Yuan
 * @since 2020-02-08
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
            //重点！！！
            filter.getExcludes().addAll(excludes);
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
            //重点！！！
            filter.getExcludes().addAll(excludeKeys);
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
    public static <T> T stringToObj(String json, Class<T> clazz) {
        T object = null;
        if (json != null) {
            object = JSON.parseObject(json, clazz);
        }
        return object;
    }
}


