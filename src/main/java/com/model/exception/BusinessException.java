/*
 * Copyright (c) 2023. CPIC All rights reserved.
 */
package com.model.exception;

import com.enums.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 自定义业务异常实现类
 *
 * @author DC Yuan
 * @since 2020-02-08
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BusinessException extends RuntimeException {

    /**
     * 错误码枚举
     */
    private final ErrorCodeEnum errorCodeEnum;

    /**
     * 错误代码
     */
    private final int errorCode;

    /**
     * 错误信息
     */
    private final String errorMessage;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getText());
        this.errorCodeEnum = errorCodeEnum;
        this.errorCode = errorCodeEnum.getCode();
        this.errorMessage = errorCodeEnum.getText();
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum, String errorMessage) {
        super(errorMessage);
        this.errorCodeEnum = errorCodeEnum;
        this.errorCode = errorCodeEnum.getCode();
        this.errorMessage = errorMessage;
    }

    public BusinessException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCodeEnum = ErrorCodeEnum.of(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorMessage) {
        super(errorMessage);
        this.errorCodeEnum = ErrorCodeEnum.SYS_ERROR;
        this.errorCode = ErrorCodeEnum.SYS_ERROR.getCode();
        this.errorMessage = errorMessage;
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getText(), cause);
        this.errorCodeEnum = errorCodeEnum;
        this.errorCode = errorCodeEnum.getCode();
        this.errorMessage = errorCodeEnum.getText();
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCodeEnum = errorCodeEnum;
        this.errorCode = errorCodeEnum.getCode();
        this.errorMessage = errorMessage;
    }

    public BusinessException(int errorCode, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCodeEnum = ErrorCodeEnum.of(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCodeEnum = ErrorCodeEnum.SYS_ERROR;
        this.errorCode = ErrorCodeEnum.SYS_ERROR.getCode();
        this.errorMessage = errorMessage;
    }
}
