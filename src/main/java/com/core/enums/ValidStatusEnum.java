package com.core.enums;

/**
 * @author spring.yuan
 * @version 1.0
 */
public enum ValidStatusEnum {
    VALID, INVALID;

    public static ValidStatusEnum getInstance(String validStatus) {
        if (validStatus != null) {
            if (validStatus.equalsIgnoreCase(VALID.name())) {
                return VALID;
            } else if (validStatus.equalsIgnoreCase(INVALID.name())) {
                return INVALID;
            } else {
                throw new IllegalArgumentException("Invalid valid status:'" + validStatus
                        + "'");
            }
        }
        return null;
    }

    public boolean isValid() {
        return this.name().equalsIgnoreCase(VALID.name());
    }

    public boolean isInvalid() {
        return this.name().equalsIgnoreCase(INVALID.name());
    }

}
