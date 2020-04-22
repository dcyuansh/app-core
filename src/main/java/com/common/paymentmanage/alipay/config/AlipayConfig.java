package com.common.paymentmanage.alipay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Component
@Data
public class AlipayConfig {

    private Logger logger = LoggerFactory.getLogger(AlipayConfig.class);


    /**
     * 商户应用id,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    //@Value("${pay.alipay.appid}")
    private String appid = "商户应用id";

    /**
     * 支付宝网关gatewayUrl
     */
    //@Value("${pay.alipay.gatewayUrl}")
    private String gatewayUrl = "支付宝gatewayUrl";

    /**
     * RSA私钥，用于对商户请求报文加签
     */
    //@Value("${pay.alipay.app-private-key}")
    private String appPrivateKey = "应用RSA私钥，用于对商户请求报文加签";

    /**
     * 支付宝RSA公钥，用于验签支付宝应答
     */
    //@Value("${pay.alipay.alipay-public-key}")
    private String alipayPublicKey = "支付宝RSA公钥，用于验签支付宝应答";

    /**
     * 同步地址
     */
    private String returnUrl;

    /**
     * 异步地址
     */
    //@Value("${pay.alipay.notify-url}")
    private String notifyUrl = "http://localhost:8443/api/alipay/notify";

    /**
     * 签名类型
     */
    private String signType = "RSA2";

    /**
     * 格式
     */
    private String formate = "json";

    /**
     * 编码
     */
    private String charset = "UTF-8";

    /**
     * 最大查询次数
     */
    private static int maxQueryRetry = 5;

    /**
     * 查询间隔（毫秒）
     */
    private static long queryDuration = 5000;

    /**
     * 最大撤销次数
     */
    private static int maxCancelRetry = 3;

    /**
     * 撤销间隔（毫秒）
     */
    private static long cancelDuration = 3000;

    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(gatewayUrl, appid, appPrivateKey, formate, charset, alipayPublicKey, signType);
    }
}
