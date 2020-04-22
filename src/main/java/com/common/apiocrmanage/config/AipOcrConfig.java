package com.common.apiocrmanage.config;

import com.baidu.aip.ocr.AipOcr;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class AipOcrConfig extends AipOcr {
    public static final String API_ID = "16306140";
    public static final String API_KEY = "D5ct0O3KEmdXTQEBdUHZlIeP";
    public static final String SECRET_KEY = "3OG3u908o6hciLW6IdGzykmtc9hAQHkR";

    public static final int CONNECTION_TIME_OUT = 60000;
    public static final int SOCKET_TIME_OUT = 20000;


    private static AipOcrConfig aipOcr_instance;


    public static AipOcrConfig getInstance() {
        if (aipOcr_instance == null) {
            synchronized (AipOcrConfig.class) {
                if (aipOcr_instance == null) {
                    aipOcr_instance = new AipOcrConfig();
                }
            }
        }
        return aipOcr_instance;
    }


    public AipOcrConfig() {
        super(API_ID, API_KEY, SECRET_KEY);
        //timeout 服务器建立连接的超时时间（单位：毫秒）
        this.setConnectionTimeoutInMillis(CONNECTION_TIME_OUT);
        //timeout 通过打开的连接传输数据的超时时间（单位：毫秒）
        this.setSocketTimeoutInMillis(SOCKET_TIME_OUT);
    }

    public AipOcrConfig(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
        //timeout 服务器建立连接的超时时间（单位：毫秒）
        this.setConnectionTimeoutInMillis(CONNECTION_TIME_OUT);
        //timeout 通过打开的连接传输数据的超时时间（单位：毫秒）
        this.setSocketTimeoutInMillis(SOCKET_TIME_OUT);
    }
}
