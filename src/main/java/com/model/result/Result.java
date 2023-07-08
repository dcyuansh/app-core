package com.model.result;

import com.enums.ErrorCodeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * api接口返回统一封装
 *
 * @author yuandechun
 * @since 2021-03-08
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result<T> implements Serializable {

    /**
     * api result code
     */
    private int code;

    /**
     * api result data
     */
    private T data;

    /**
     * api result message
     */
    private String msg;


    public Result() {
        this.setMsg("");
    }

    Result(int code, T data, String message) {
        this.setCode(code);
        this.setMsg(message);
        this.setData(data);
    }


    public static <T> Result<T> create(int code) {
        return new Result<>(code, null, null);
    }

    public static <T> Result<T> create(int code, String message) {
        return new Result<>(code, null, message);
    }

    public static <T> Result<T> create(int code, T data) {
        return new Result<T>(code, data, null);
    }

    public static <T> Result<T> create(int code, T data, String message) {
        return new Result<T>(code, data, message);
    }

    public static <T> Result<T> create(ErrorCodeEnum code, T data, String message) {
        return create(code.getCode(), data, message);
    }


    public static <T> Result<T> success() {
        return create(ErrorCodeEnum.SUCCESS.getCode(), null, null);
    }

    public static <T> Result<T> success(T data) {
        return create(ErrorCodeEnum.SUCCESS.getCode(), data, null);
    }

    public static <T> Result<T> success(T data, String message) {
        return create(ErrorCodeEnum.SUCCESS.getCode(), data, message);
    }


    public static <T> Result<T> error() {
        return create(ErrorCodeEnum.ERROR.getCode(), null, null);
    }

    public static <T> Result<T> error(String message) {
        return create(ErrorCodeEnum.ERROR.getCode(), null, message);
    }

    public static <T> Result<T> error(T data, String message) {
        return create(ErrorCodeEnum.ERROR.getCode(), data, message);
    }

    public static <T> Result<T> error(ErrorCodeEnum errorCodeEnum) {
        return create(errorCodeEnum.getCode(), null, null);
    }

    public static <T> Result<T> error(ErrorCodeEnum errorCodeEnum, String message) {
        return create(errorCodeEnum.getCode(), null, message);
    }

    public static <T> Result<T> error(ErrorCodeEnum errorCodeEnum, T data, String message) {
        return create(errorCodeEnum.getCode(), data, message);
    }

}
