package com.common.payservicemanage.service;

import com.model.data.DataModel;

/**
 * @author DC Yuan
 * @version 1.0
 */
public interface PayService {

    /**
     * 支付方法
     *
     * @param payModel
     * @return
     */
    DataModel pay(DataModel payModel);

    /**
     * 支付标识
     *
     * @return
     */
    String channelId();
}
