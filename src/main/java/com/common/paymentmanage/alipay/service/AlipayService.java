package com.common.paymentmanage.alipay.service;

import com.alipay.api.AlipayApiException;
import com.core.data.model.DataModel;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public interface AlipayService {

    /***
     * @param orderNo: 订单编号
     * @param amount:  实际支付金额
     * @param body:    订单描述
     * @return
     * @Description: 创建支付宝订单
     */
    String createOrder(String orderNo, double amount, String body) throws AlipayApiException;


    /***
     * @param tradeStatus: 支付宝交易状态
     * @param orderNo:     订单编号
     * @param tradeNo:     支付宝订单号
     * @return
     * @Description:
     * @Author:
     * @Date: 2019/8/1
     */
    boolean notify(String tradeStatus, String orderNo, String tradeNo);


    /***
     * @param request
     * @return
     * @Description: 校验签名
     * @Author:
     * @Date: 2019/8/1
     */
    boolean rsaCheckV1(HttpServletRequest request);


    /***
     * @param orderNo:      订单编号
     * @param amount:       实际支付金额
     * @param refundReason: 退款原因
     * @return
     * @Description: 退款
     */
    DataModel refund(String orderNo, double amount, String refundReason);

}
