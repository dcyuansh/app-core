package com.core.enums;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum StatusEnum {
    NOTSTART, START, SUCCESS, FAILED, TRUE, FALSE, INPROGRESS, MANUALCHECK, RESOLVED, CLOSE, REOPEN, STOPPED, ABORT, END, UNDEFINED;

    public static StatusEnum getInstance(String resultStatus) {
        StatusEnum result = null;
        try {
            result = StatusEnum.valueOf(resultStatus.toUpperCase());
        } catch (Exception e) {
            result = StatusEnum.UNDEFINED;
        }
        return result;
    }
}

