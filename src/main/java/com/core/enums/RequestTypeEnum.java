package com.core.enums;

/**
 * @author spring
 * @version 1.0
 */
public enum RequestTypeEnum {

    GET, POST, PUT, PATCH, DELETE, COPY, HEAD, OPTIONS, LINK, UNLINK, PURGE, LOCK, UNLOCK, PROPFIND, VIEW;

    public boolean isGet() {
        return this.equals(RequestTypeEnum.GET);
    }

    public boolean isPost() {
        return this.equals(RequestTypeEnum.POST);
    }

    public boolean isPut() {
        return this.equals(RequestTypeEnum.PUT);
    }

    public boolean isPatch() {
        return this.equals(RequestTypeEnum.PATCH);
    }

    public boolean isDelete() {
        return this.equals(RequestTypeEnum.DELETE);
    }

    public boolean isCopy() {
        return this.equals(RequestTypeEnum.COPY);
    }

    public boolean isHead() {
        return this.equals(RequestTypeEnum.HEAD);
    }

    public boolean isOptions() {
        return this.equals(RequestTypeEnum.OPTIONS);
    }

    public boolean isLink() {
        return this.equals(RequestTypeEnum.LINK);
    }

    public boolean isUnlink() {
        return this.equals(RequestTypeEnum.UNLINK);
    }

    public boolean isPurge() {
        return this.equals(RequestTypeEnum.PURGE);
    }

    public boolean isLock() {
        return this.equals(RequestTypeEnum.LOCK);
    }

    public boolean isUnlock() {
        return this.equals(RequestTypeEnum.UNLOCK);
    }

    public boolean isPropfind() {
        return this.equals(RequestTypeEnum.PROPFIND);
    }

    public boolean isView() {
        return this.equals(RequestTypeEnum.VIEW);
    }


    public static RequestTypeEnum getInstance(String requestType) {
        RequestTypeEnum result = null;
        try {
            result = RequestTypeEnum.valueOf(requestType.toUpperCase());
        } catch (Exception e) {
            result = RequestTypeEnum.GET;
        }
        return result;
    }
}
