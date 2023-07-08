package com.utils;

import java.util.Collection;

/**
 * @author DC Yuan
 * @since 2020-02-08
 */
public class RandomUtils {

    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final java.util.Random RANDOM = new java.util.Random();


    /**
     * @param size 指定字符串的长度
     * @return 返回随机字符串，长度为size
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
     */
    public static int randomVerCode() {
        int x = Math.abs(RANDOM.nextInt(899999));
        return x + 100000;
    }


    /**
     * 获取随机数 [ start, end ] 或 [ end, start ]
     */
    public static int getRandomBetween(final int start, final int end) {
        return end > start ? RANDOM.nextInt(end - start + 1) + start : RANDOM.nextInt(start - end + 1) + end;
    }


    /**
     * 从集合中获取随机一个
     */
    public static <T> T getCollRandom(Collection<T> collections) {
        if (collections == null || collections.isEmpty())
            return null;
        Object[] os = collections.toArray();
        int index = getRandomBetween(0, os.length - 1);
        return (T) os[index];
    }


    /**
     * 从 [min, max]中取出num个不重复的随机数
     */
    public static java.util.List<Integer> getRandomListVal(int min, int max, int num) {
        final java.util.List<Integer> list = new java.util.LinkedList<Integer>();
        if (max < 0)
            return list;
        if (num <= 0)
            return list;
        if (max < min)
            return list;
        if (num > (max - min + 1)) {
            num = max - min + 1;
        }
        for (int i = 0; i < num; ++i) {
            int val = getRandomBetween(min, max);
            while (list.contains(val)) {
                val = min + ((val + 1 - min) % (max - min + 1));
            }
            list.add(val);
        }
        return list;
    }
}
