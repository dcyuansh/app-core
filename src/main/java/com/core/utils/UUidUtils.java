package com.core.utils;

import java.util.UUID;

/**
 * @author DC Yuan
 * @version 1.0
 */
public class UUidUtils {

    /***
     * get uuid
     * @return 返回uuid字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }


    /***
     * get uuid code
     * @return 返回uuid,去掉了中划线-
     */
    public static String getUUIDCode() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

}
