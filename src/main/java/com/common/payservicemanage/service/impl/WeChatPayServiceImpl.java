package com.common.payservicemanage.service.impl;

import com.common.payservicemanage.service.PayService;
import com.core.data.model.DataModel;
import org.springframework.stereotype.Service;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Service("weChatPayServiceImpl")
public class WeChatPayServiceImpl implements PayService {

    @Override
    public DataModel pay(DataModel payModel) {
        DataModel payResult = new DataModel();
        payResult.setFieldValue("payStatus", "微信支付成功");
        return payResult;
    }

    @Override
    public String channelId() {
        return "WeChatPay";
    }
}
