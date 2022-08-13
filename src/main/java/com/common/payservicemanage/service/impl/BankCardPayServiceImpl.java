package com.common.payservicemanage.service.impl;

import com.common.payservicemanage.service.PayService;
import com.core.data.model.DataModel;
import org.springframework.stereotype.Service;

/**
 * @author dc.yuan
 * @version 1.0
 */
@Service("bankCardPayServiceImpl")
public class BankCardPayServiceImpl implements PayService {

    @Override
    public DataModel pay(DataModel payModel) {
        DataModel payResult = new DataModel();
        payResult.setFieldValue("payStatus", "银行卡支付成功");
        return payResult;
    }

    @Override
    public String channelId() {
        return "BankCardPay";
    }
}
