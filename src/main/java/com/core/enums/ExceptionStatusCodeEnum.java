package com.core.enums;


/***
 *
 * @author dechun.yuan
 *
 */
public enum ExceptionStatusCodeEnum {
    Success("001", "Success"),
    Fail("002", "Fail"),
    UserNotExist("003", "User not exist"),
    InValidParameter("004", "Invalid parameter"),
    DataFormatException("005", "DataFormat exception"),
    DataNotExistException("006", "DataNotExistException"),
    TimeFormatException("007", "TimeFormat Exception"),
    PictureFormatException("008", "PictureFormat Exception"),
    IllegalArgumentException("009", "IllegalArgumentException"),
    TokenInvalidOrOverdueException("010", "Token invalid or overdue exception"),
    AuthorizationCodeError("011", "Authorization code error"),
    WrongSignatureException("012", "Wrong Signature Exception"),
    ArithmeticException("013", "ArithmeticException"),
    ClassCastException("014", "ClassCastException"),
    MissingServletRequestParameter("400", "Missing servletRequest parameter"),
    TypeMismatchException("401", "Request parameter Type not match"),
    RequestMethodNotAllowed("405", "Request method  not Allowed"),
    SystemException("500", "System Exception");


    private String code;
    private String msg;

    ExceptionStatusCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }
}
