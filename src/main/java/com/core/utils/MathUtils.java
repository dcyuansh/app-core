package com.core.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class MathUtils {


    /**
     * 四舍五入保留newScale位小数
     *
     * @param newScale 精确度
     * @param v        原数据
     * @return 返回四色五入后的结果
     */
    public static double round(double v, int newScale) {
        BigDecimal b = new BigDecimal(Double.toString(v));
        return b.setScale(newScale, RoundingMode.HALF_UP).doubleValue();
    }


    /**
     * 最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static int GetGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

}
