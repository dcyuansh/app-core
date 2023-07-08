package com.common.payservicemanage.service;

import com.model.data.DataModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author DC Yuan
 * @version 1.0
 */
@Service
public class PayRouteService {

    public Set<PayService> payServiceSet;

    public Map<String, PayService> payServiceMap = new HashMap<>();


    public PayRouteService(Set<PayService> payServiceSet) {
        this.payServiceSet = payServiceSet;
        for (PayService payService : payServiceSet) {
            payServiceMap.put(payService.channelId(), payService);
        }
    }


    /**
     * 支付方法,统一路由
     *
     * @param payModel
     * @return
     */
    public DataModel pay(DataModel payModel) {
        PayService payService = payServiceMap.get(payModel.getStringValue("channelId"));
        return payService.pay(payModel);
    }
}
