package com.core.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class MathUtils {


    /**
     * @param newScale 精确度
     * @param v        原数据
     * @return 返回四色五入后的结果
     * @desc 四舍五入保留newScale位小数
     */
    public static double round(double v, int newScale) {
        BigDecimal b = new BigDecimal(Double.toString(v));
        return b.setScale(newScale, RoundingMode.HALF_UP).doubleValue();
    }


}
