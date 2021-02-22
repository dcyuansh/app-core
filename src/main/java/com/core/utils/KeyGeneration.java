package com.core.utils;

/**
 * @author spring
 * @version 1.0
 */
public class KeyGeneration {

    private static final String LOCAL_TIME_VAULE_FORMAT = "yyyyMMddHHmmssSSS";

    private static KeyGeneration keyGeneration = null;

    private KeyGeneration() {
    }

    /**
     * 单例实例
     */
    public static KeyGeneration getInstance() {
        if (keyGeneration == null) {
            synchronized (KeyGeneration.class) {
                if (keyGeneration == null) {
                    keyGeneration = new KeyGeneration();
                }
            }
        }
        return keyGeneration;
    }


    /**
     * 生成13位时间戳key
     */
    public synchronized String toEpochSecond() {
        String id = LocalDateTimeUtils.formatNow(LOCAL_TIME_VAULE_FORMAT);
        return id;
    }


    /**
     * 生成13位时间戳key + 6位随机数
     */
    public synchronized String KeyValue() {
        String id = toEpochSecond() + String.valueOf(RandomUtils.randomVerCode());
        return id;
    }
}
