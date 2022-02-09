package com.common.payservicemanage.service;

import com.core.data.model.DataModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author spring.yuan
 * @version 1.0
 */
@Service
public class PayRouteService {

    Set<PayService> payServiceSet;

    private Map<String, PayService> payServiceMap = new HashMap<>();


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
