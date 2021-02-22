package com.core.utils;

import com.core.utils.converter.BooleanConverter;
import com.core.utils.converter.IntegerConverter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author spring
 * @version 1.0
 */
public class PropertiesUtils {

    /***
     *  load属性文件
     *  @param fileName fileName
     *  路径一定要在class下面及java根目录或者resource跟目录下
     */
    public static Properties loadProperties(String fileName) {
        Properties properties = null;
        InputStream inputStream = null;
        try {
            //将文件加载为流
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
            if (inputStream == null) {
                throw new FileNotFoundException(fileName + "can not found file!");
            }
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return properties;
    }


    /***
     *
     * @param properties
     * @param key
     * @param defaultValue 当属性文件中找不到的时候设置的默认值
     * @return
     */
    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }


    /***
     *
     * @param properties
     * @param key
     * @param defaultValue 当属性文件中找不到的时候设置的默认值
     * @return
     */
    public static int getInt(Properties properties, String key, int defaultValue) {
        int value = defaultValue;
        if (properties.containsKey(key)) {
            value = (Integer) IntegerConverter.convert(properties.getProperty(key));
        }
        return value;
    }


    /***
     *
     * @param properties
     * @param key
     * @param defaultValue 当属性文件中找不到的时候设置的默认值
     * @return
     */
    public static boolean getBoolean(Properties properties, String key, Boolean defaultValue) {
        boolean value = defaultValue;
        if (properties.containsKey(key)) {
            value = (boolean) BooleanConverter.convert(properties.getProperty(key));
        }
        return value;
    }
}
