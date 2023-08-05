package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * yes or no枚举实现类
 *
 * @author spring.yuan
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum YesOrNoEnum {

    YES("Y", 1, "是"),
    NO("N", 0, "否"),

    ;

    /**
     * 代码
     */
    private final String code;

    /**
     * 数值
     */
    private final Integer num;

    /**
     * 描述
     */
    private final String text;

    /**
     * 根据code匹配枚举
     *
     * @param code
     * @return
     */
    public static YesOrNoEnum of(String code) {
        return Arrays.stream(values())
                .filter(v -> Objects.equals(code, v.getCode()))
                .findAny()
                .orElse(null);
    }

    /**
     * 根据num匹配枚举
     *
     * @param num
     * @return
     */
    public static YesOrNoEnum of(Integer num) {
        return Arrays.stream(values())
                .filter(v -> Objects.equals(num, v.getNum()))
                .findAny()
                .orElse(null);
    }

}
