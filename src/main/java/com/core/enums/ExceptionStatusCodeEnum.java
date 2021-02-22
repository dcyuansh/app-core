package com.core.enums;


/***
 *
 * @author spring
 *
 */
public enum ExceptionStatusCodeEnum implements CodeMessageEnum {
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
    private String message;

    ExceptionStatusCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
