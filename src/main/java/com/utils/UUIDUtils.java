package com.utils;

import java.util.UUID;

/**
 * @author DC Yuan
 * @since 2020-02-08
 */
public class UUIDUtils {

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
