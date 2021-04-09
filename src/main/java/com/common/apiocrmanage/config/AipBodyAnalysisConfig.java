package com.common.apiocrmanage.config;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class AipBodyAnalysisConfig extends AipBodyAnalysis {

    public static final String API_ID = "23951074";
    public static final String API_KEY = "8SGa3in8fVjSR80RHdYSYW3S";
    public static final String SECRET_KEY = "eSY6AAGO5RgTxlSHtGUhgbCzFZsavcHy";

    public static final int CONNECTION_TIME_OUT = 60000;
    public static final int SOCKET_TIME_OUT = 20000;


    private static AipBodyAnalysisConfig aipBody_instance;


    public static AipBodyAnalysisConfig getInstance() {
        if (aipBody_instance == null) {
            synchronized (AipBodyAnalysisConfig.class) {
                if (aipBody_instance == null) {
                    aipBody_instance = new AipBodyAnalysisConfig();
                }
            }
        }
        return aipBody_instance;
    }


    public AipBodyAnalysisConfig() {
        super(API_ID, API_KEY, SECRET_KEY);
        //timeout 服务器建立连接的超时时间（单位：毫秒）
        this.setConnectionTimeoutInMillis(CONNECTION_TIME_OUT);
        //timeout 通过打开的连接传输数据的超时时间（单位：毫秒）
        this.setSocketTimeoutInMillis(SOCKET_TIME_OUT);
    }

    public AipBodyAnalysisConfig(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
        //timeout 服务器建立连接的超时时间（单位：毫秒）
        this.setConnectionTimeoutInMillis(CONNECTION_TIME_OUT);
        //timeout 通过打开的连接传输数据的超时时间（单位：毫秒）
        this.setSocketTimeoutInMillis(SOCKET_TIME_OUT);
    }
}
