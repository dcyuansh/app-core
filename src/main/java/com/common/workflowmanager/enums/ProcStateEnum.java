package com.common.workflowmanager.enums;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public enum ProcStateEnum {
    STARTED, INPROGRESS, COMPLETED, CLOSED, REJECTED, UNDEFINED;

    public boolean isStarted() {
        return this.equals(ProcStateEnum.STARTED);
    }

    public boolean isInprogress() {
        return this.equals(ProcStateEnum.INPROGRESS);
    }

    public boolean isCompleted() {
        return this.equals(ProcStateEnum.COMPLETED);
    }

    public boolean isClosed() {
        return this.equals(ProcStateEnum.CLOSED);
    }

    public boolean isRejected() {
        return this.equals(ProcStateEnum.REJECTED);
    }

    public static ProcStateEnum getInstance(String procState) {
        ProcStateEnum result = null;
        try {
            result = ProcStateEnum.valueOf(procState.toUpperCase());
        } catch (Exception e) {
            result = ProcStateEnum.UNDEFINED;
        }
        return result;
    }
}
