package com.aspect;

import com.enums.ErrorCodeEnum;
import com.model.exception.BusinessException;
import com.model.exception.ValidationException;
import com.model.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * 系统统一异常处理实现类
 *
 * @author DC Yuan
 * @since 2020-02-08
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    /**
     * validation exception统一处理
     */
    @ExceptionHandler(ValidationException.class)
    public Result<String> validationExceptionHandler(ValidationException ex) {
        Result<String> result = Result.error();
        result.setCode(ErrorCodeEnum.CMN_ILLEGAL_ARG.getCode());
        result.setMsg(ex.getMessage());
        log.error("[GlobalExceptionHandlerAdvice] validationExceptionHandler, illegal_arg error:", ex);
        return result;
    }

    /**
     * 参数异常统一处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<String> methodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException ex) {
        Map<String, String> errorMsg = new HashMap<>(64);
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorMsg.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        Result<String> result = Result.error();
        result.setCode(ErrorCodeEnum.CMN_ILLEGAL_ARG.getCode());
        result.setMsg(errorMsg.toString());
        log.error("[GlobalExceptionHandlerAdvice] MethodArgumentNotValidException, error:", ex);
        return result;
    }

    /**
     * 自定义业务异常，统一处理
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> businessExceptionHandler(BusinessException ex) {
        Result<String> result = Result.error();
        if (ex.getErrorCode() == ErrorCodeEnum.SYS_ERROR.getCode()) {
            result.setCode(ErrorCodeEnum.ERROR.getCode());
        } else {
            result.setCode(ex.getErrorCode());
        }
        result.setMsg(ex.getMessage());
        log.error("[GlobalExceptionHandlerAdvice] businessExceptionHandler, business error: ", ex);
        return result;
    }

    /**
     * 系统运行异常，统一处理
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<String> commonExceptionHandler(RuntimeException ex) {
        Result<String> result = Result.error();
        result.setCode(ErrorCodeEnum.ERROR.getCode());
        result.setMsg(ex.getMessage());
        log.error("[GlobalExceptionHandlerAdvice] commonExceptionHandler, error: ", ex);
        return result;
    }

}
