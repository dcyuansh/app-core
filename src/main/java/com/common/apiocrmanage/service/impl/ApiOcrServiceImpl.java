package com.common.apiocrmanage.service.impl;

import com.baidu.aip.util.Util;
import com.common.apiocrmanage.config.AipOcrConfig;
import com.common.apiocrmanage.service.ApiOcrService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author dechun.yuan
 * @version 1.0
 */
@Service
public class ApiOcrServiceImpl implements ApiOcrService {

    /***
     * 文字识别
     * @param file
     * @return
     */
    public JSONObject enhancedGeneral(String file) {
        byte[] bytes = new byte[0];
        try {
            bytes = Util.readFileByBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return enhancedGeneral(bytes);
    }


    /***
     * 文字识别
     * @param bytes
     * @return
     */
    public JSONObject enhancedGeneral(byte[] bytes) {
        HashMap<String, String> options = new HashMap<>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        JSONObject jsonObject = AipOcrConfig.getInstance().enhancedGeneral(bytes, options);
        return jsonObject;
    }


    /***
     *  身份证识别
     *  read picture by file path
     * 身份证识别
     * @param filePath
     * @param side front or back
     * @return
     */
    public JSONObject idCard(String filePath, String side) {
        byte[] bytes = new byte[0];
        try {
            bytes = Util.readFileByBytes(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idCard(bytes, side);
    }


    /***
     * 身份证识别
     * read picture by byte[]
     * @param bytes
     * @param side front or back
     * @return
     */
    public JSONObject idCard(byte[] bytes, String side) {
        HashMap<String, String> options = new HashMap<>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "true");
        // 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能，
        // 默认不开启，即：false。
        // 可选值:true-开启；false-不开启
        JSONObject jsonObject = AipOcrConfig.getInstance().idcard(bytes, side, options);
        return jsonObject;
    }


    /***
     * 银行卡识别
     * @param file
     * @return
     * result中的bank_card_type 银行卡类型，0:不能识别; 1: 借记卡; 2: 信用卡
     */
    public JSONObject bankCard(String file) {
        byte[] bytes = new byte[0];
        try {
            bytes = Util.readFileByBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankCard(bytes);
    }


    /***
     * 银行卡识别
     * @param bytes
     * @return
     * result中的bank_card_type 银行卡类型，0:不能识别; 1: 借记卡; 2: 信用卡
     */
    public JSONObject bankCard(byte[] bytes) {
        HashMap<String, String> options = new HashMap<>();
        JSONObject jsonObject = AipOcrConfig.getInstance().bankcard(bytes, options);
        return jsonObject;
    }


    /***
     * 驾驶证识别
     * @param file
     * @return
     */
    public JSONObject drivingLicense(String file) {
        byte[] bytes = new byte[0];
        try {
            bytes = Util.readFileByBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drivingLicense(bytes);
    }


    /***
     *
     * 驾驶证识别
     * @param bytes
     * @return
     */
    public JSONObject drivingLicense(byte[] bytes) {
        HashMap<String, String> options = new HashMap<>();
        options.put("detect_direction", "false");  //不检查朝上
        JSONObject jsonObject = AipOcrConfig.getInstance().drivingLicense(bytes, options);
        return jsonObject;
    }


    /***
     * 行驶证识别
     * @param file
     * @return
     */
    public JSONObject vehicleLicense(String file) {
        byte[] bytes = new byte[0];
        try {
            bytes = Util.readFileByBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vehicleLicense(bytes);
    }


    /***
     * 行驶证识别
     * @param bytes
     * @return
     */
    public JSONObject vehicleLicense(byte[] bytes) {
        HashMap<String, String> options = new HashMap<>();
        options.put("detect_direction", "false");  //不检查朝上
        options.put("accuracy", "normal");
        //  normal 使用快速服务，1200ms左右时延；缺省或其它值使用高精度服务，1600ms左右时延
        JSONObject jsonObject = AipOcrConfig.getInstance().vehicleLicense(bytes, options);
        return jsonObject;
    }


    /***
     * 车牌识别
     * @param file
     * @return
     */
    public JSONObject plateLicense(String file) {
        byte[] bytes = new byte[0];
        try {
            bytes = Util.readFileByBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plateLicense(bytes);
    }


    /***
     * 车牌识别
     * @param bytes
     * @return
     */
    public JSONObject plateLicense(byte[] bytes) {
        HashMap<String, String> options = new HashMap<>();
        options.put("multi_detect", "true");
        //是否检测多张车牌，默认为false，当置为true的时候可以对一张图片内的多张车牌进行识别
        JSONObject jsonObject = AipOcrConfig.getInstance().plateLicense(bytes, options);
        return jsonObject;
    }


    /***
     * 营业执照识别
     * @param file
     * @return
     */
    public JSONObject businessLicense(String file) {
        byte[] bytes = new byte[0];
        try {
            bytes = Util.readFileByBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return businessLicense(bytes);
    }


    /***
     * 营业执照识别
     * @param bytes
     * @return
     */
    public JSONObject businessLicense(byte[] bytes) {
        HashMap<String, String> options = new HashMap<>();
        JSONObject jsonObject = AipOcrConfig.getInstance().businessLicense(bytes, options);
        return jsonObject;
    }


    /***
     * 二维码图片识别
     * @param url
     * @return
     */
    @Override
    public JSONObject generalUrl(String url) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("recognize_granularity", "big");
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("vertexes_location", "true");
        options.put("probability", "true");
        return generalUrl(url, options);
    }


    /***
     * 二维码图片识别
     * @param url
     * @param options
     * @return
     */
    @Override
    public JSONObject generalUrl(String url, HashMap<String, String> options) {
        JSONObject jsonObject = AipOcrConfig.getInstance().generalUrl(url, options);
        return jsonObject;
    }


}
