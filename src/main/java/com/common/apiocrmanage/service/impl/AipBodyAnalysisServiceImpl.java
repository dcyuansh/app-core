package com.common.apiocrmanage.service.impl;

import com.common.apiocrmanage.config.AipBodyAnalysisConfig;
import com.common.apiocrmanage.service.AipBodyAnalysisService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author dc.yuan
 * @version 1.0
 */
@Service
public class AipBodyAnalysisServiceImpl implements AipBodyAnalysisService {

    @Override
    public JSONObject bodySeg(byte[] image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("type", "scoremap");
        JSONObject res = AipBodyAnalysisConfig.getInstance().bodySeg(image, null);
        return res;
        //return res.get("foreground").toString();
    }
}
