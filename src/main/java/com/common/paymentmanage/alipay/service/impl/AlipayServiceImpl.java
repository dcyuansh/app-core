package com.common.paymentmanage.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.common.paymentmanage.alipay.config.AlipayConfig;
import com.common.paymentmanage.alipay.enums.AlipayTradeStatusEnum;
import com.common.paymentmanage.alipay.service.AlipayService;
import com.core.data.model.DataModel;
import com.core.enums.StatusEnum;
import com.core.enums.ResultEnum;
import com.core.exception.ExceptionHelper;
import com.core.utils.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    private Logger logger = LoggerFactory.getLogger(AlipayServiceImpl.class);

    @Autowired
    private AlipayConfig alipayConfig;
    @Autowired
    private AlipayClient alipayClient;


    /***
     *  创建订单
     * @param orderNo: 订单编号
     * @param amount:  实际支付金额
     * @param body:    订单描述
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String createOrder(String orderNo, double amount, String body) throws AlipayApiException {
        /**
         *  SDK已经封装掉了公共参数，这里只需要传入业务参数。
         *  以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
         */
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setSubject(body);
        model.setOutTradeNo(orderNo);
        model.setTotalAmount(String.valueOf(amount));
        model.setProductCode("QUICK_MSECURITY_PAY");
        model.setPassbackParams("公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数");

        /***
         * 实例化具体API对应的request类,类名称和接口名称对应,
         * 当前调用接口名称：alipay.trade.app.pay
         */
        AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
        ali_request.setBizModel(model);
        ali_request.setNotifyUrl(alipayConfig.getNotifyUrl());// 回调地址
        AlipayTradeAppPayResponse ali_response = alipayClient.sdkExecute(ali_request);

        //就是orderString 可以直接给客户端请求，无需再做处理。
        return ali_response.getBody();
    }


    /***
     *
     * @param tradeStatus: 支付宝交易状态
     * @param orderNo:     订单编号
     * @param tradeNo:     支付宝订单号
     * @return
     */
    @Override
    public boolean notify(String tradeStatus, String orderNo, String tradeNo) {
        if (AlipayTradeStatusEnum.TRADE_FINISHED.equals(tradeStatus)
                || AlipayTradeStatusEnum.TRADE_SUCCESS.equals(tradeStatus)) {
            // 支付成功，根据业务逻辑修改相应数据的状态
            // boolean state = orderPaymentService.updatePaymentState(orderNo, tradeNo);
            //if (state) {
            //    return true;
            // }
        }
        return false;
    }


    /***
     *  校验签名
     * @param request
     * @return
     */
    @Override
    public boolean rsaCheckV1(HttpServletRequest request) {
        try {
            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put(name, valueStr);
            }
            boolean verifyResult = AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipayPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());
            return verifyResult;
        } catch (AlipayApiException e) {
            logger.debug("verify sigin error, exception is:{}", e);
            return false;
        }
    }


    /***
     * 退款
     * @param orderNo:      订单编号
     * @param amount:       实际支付金额
     * @param refundReason: 退款原因
     * @return
     */
    @Override
    public DataModel refund(String orderNo, double amount, String refundReason) {
        DataModel resultModel = new DataModel();
        if (StringUtils.isEmpty(orderNo)) {
            throw ExceptionHelper.getInstance().handleValidationException("订单编号不能为空");
        }
        if (amount <= 0) {
            throw ExceptionHelper.getInstance().handleValidationException("退款金额必须大于0");
        }
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        // 商户订单号
        model.setOutTradeNo(orderNo);
        // 退款金额
        model.setRefundAmount(String.valueOf(amount));
        // 退款原因
        model.setRefundReason(refundReason);
        // 退款订单号(同一个订单可以分多次部分退款，当分多次时必传)
        // model.setOutRequestNo(UUID.randomUUID().toString());
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        alipayRequest.setBizModel(model);
        AlipayTradeRefundResponse alipayResponse = null;
        try {
            alipayResponse = alipayClient.execute(alipayRequest);
        } catch (AlipayApiException e) {
            logger.error("订单退款失败，异常原因:{}", e);
        }
        if (alipayResponse != null) {
            String code = alipayResponse.getCode();
            String subCode = alipayResponse.getSubCode();
            String subMsg = alipayResponse.getSubMsg();
            if ("10000".equals(code)
                    && StringUtils.isEmpty(subCode)
                    && StringUtils.isEmpty(subMsg)) {
                // 表示退款申请接受成功，结果通过退款查询接口查询
                // 修改用户订单状态为退款
                resultModel.setFieldValue(ResultEnum.RESULT_STATUS.getresultType(), StatusEnum.SUCCESS);
                resultModel.setFieldValue(ResultEnum.RESULT_CODE.getresultType(), "REFUND_SUCCESS");
                resultModel.setFieldValue(ResultEnum.RESULT_MESSAGE.getresultType(), "订单退款成功");
            } else {
                resultModel.setFieldValue(ResultEnum.RESULT_STATUS.getresultType(), StatusEnum.FAILED);
                resultModel.setFieldValue(ResultEnum.RESULT_CODE.getresultType(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
                resultModel.setFieldValue(ResultEnum.RESULT_MESSAGE.getresultType(), subCode + ":" + subMsg);
            }
        }
        return resultModel;
    }
}
