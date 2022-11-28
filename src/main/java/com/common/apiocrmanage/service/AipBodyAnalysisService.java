package com.common.apiocrmanage.service;

import org.json.JSONObject;

/**
 * @author DC Yuan
 * @version 1.0
 */
public interface AipBodyAnalysisService {


    /**
     * @param image 图片byte
     * @return
     * @desc 调用人脸识别OCR，返回前景人像图（透明背景）
     */
    JSONObject bodySeg(byte[] image);
}
