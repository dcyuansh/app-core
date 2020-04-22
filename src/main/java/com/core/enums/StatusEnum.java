package com.core.enums;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum StatusEnum {
    SUCCESS, FAILED, TRUE, FALSE, NOTSTART, INPROGRESS, RESOLVED, CLOSE, REOPEN, UNDEFINED;

    public boolean isSuccess() {
        return this.equals(StatusEnum.SUCCESS);
    }

    public boolean isFailed() {
        return this.equals(StatusEnum.FAILED);
    }

    public boolean isTrue() {
        return this.equals(StatusEnum.TRUE);
    }

    public boolean isFalse() {
        return this.equals(StatusEnum.FALSE);
    }

    public boolean isNotStart() {
        return this.equals(StatusEnum.NOTSTART);
    }

    public boolean isInProgress() {
        return this.equals(StatusEnum.INPROGRESS);
    }

    public boolean isResolved() {
        return this.equals(StatusEnum.RESOLVED);
    }

    public boolean isClose() {
        return this.equals(StatusEnum.CLOSE);
    }

    public boolean isReOpen() {
        return this.equals(StatusEnum.REOPEN);
    }

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

