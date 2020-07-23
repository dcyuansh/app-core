package com.core.utils;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class RandomUtils {

    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final java.util.Random RANDOM = new java.util.Random();

    /**
     * 随机生成指定长度的字符串
     *
     * @param size
     * @return
     */
    public static String randomStr(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(RANDOM_STR.charAt(RANDOM.nextInt(RANDOM_STR.length())));
        }
        return sb.toString();
    }


    /**
     * 随机生成6位验证码，可能会重复
     *
     * @return
     */
    public static int randomVerCode() {
        int x = Math.abs(RANDOM.nextInt(899999));
        return x + 100000;
    }
}
