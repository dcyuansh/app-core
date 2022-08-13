package com.core.utils;

/**
 * @author dc.yuan
 * @version 1.0
 */
public class KeyGenerationUtils {

    private static final String LOCAL_TIME_VAULE_FORMAT = "yyyyMMddHHmmssSSS";

    private static KeyGenerationUtils keyGenerationUtils = null;

    private KeyGenerationUtils() {
    }

    /**
     * 单例实例
     */
    public static KeyGenerationUtils getInstance() {
        if (keyGenerationUtils == null) {
            synchronized (KeyGenerationUtils.class) {
                if (keyGenerationUtils == null) {
                    keyGenerationUtils = new KeyGenerationUtils();
                }
            }
        }
        return keyGenerationUtils;
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
