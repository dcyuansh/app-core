package com.common.workflowmanager.enums;

/**
 * @author spring
 * @version 1.0
 */
public enum ProcApproveStatusEnum {
    APPROVED, DISAPPROVED, UNDEFINED;

    public boolean isApproved() {
        return this.equals(ProcApproveStatusEnum.APPROVED);
    }

    public boolean isDisApproved() {
        return this.equals(ProcApproveStatusEnum.DISAPPROVED);
    }

    public static ProcApproveStatusEnum getInstance(String approveCode) {
        ProcApproveStatusEnum result = null;
        try {
            result = ProcApproveStatusEnum.valueOf(approveCode.toUpperCase());
        } catch (Exception e) {
            result = ProcApproveStatusEnum.UNDEFINED;
        }
        return result;
    }
}
