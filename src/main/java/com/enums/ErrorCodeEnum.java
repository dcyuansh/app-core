package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 错误代码枚举实现类
 *
 * @author yuandechun
 * @since 2023-07-08
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    SUCCESS(0, "业务处理成功"),
    ERROR(1, "业务处理失败"),
    CMN_ILLEGAL_ARG(100, "参数错误"),
    SYS_ERROR(201, "系统异常"),
    DB_ERROR(301, "数据库操作异常"),


    ;

    /**
     * 代码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String text;


    public static ErrorCodeEnum getByCode(Integer code) {
        return Arrays.stream(values())
                .filter(v -> Objects.equals(code, v.getCode()))
                .findAny()
                .orElse(null);
    }

    public static ErrorCodeEnum of(Integer code) {
        return getByCode(code);
    }

}
