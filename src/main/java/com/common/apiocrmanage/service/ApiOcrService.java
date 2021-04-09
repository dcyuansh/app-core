package com.common.apiocrmanage.service;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author spring.yuan
 * @version 1.0
 */
public interface ApiOcrService {


    /***
     * 文字识别
     * @param file
     * @return
     */
    JSONObject enhancedGeneral(String file);


    /***
     * 文字识别
     * @param bytes
     * @return
     */
    JSONObject enhancedGeneral(byte[] bytes);


    /**
     * @param filePath
     * @param side     front or back
     * @return 身份证识别
     * read picture by file path
     * 身份证识别
     */
    JSONObject idCard(String filePath, String side);


    /**
     * 身份证识别
     * read picture by byte[]
     *
     * @param bytes
     * @param side  front or back
     * @return
     */
    JSONObject idCard(byte[] bytes, String side);


    /***
     * 银行卡识别
     * @param file
     * @return
     * result中的bank_card_type 银行卡类型，0:不能识别; 1: 借记卡; 2: 信用卡
     */
    JSONObject bankCard(String file);


    /***
     * 银行卡识别
     * @param bytes
     * @return
     * result中的bank_card_type 银行卡类型，0:不能识别; 1: 借记卡; 2: 信用卡
     */
    JSONObject bankCard(byte[] bytes);


    /***
     * 驾驶证识别
     * @param file
     * @return
     */
    JSONObject drivingLicense(String file);


    /***
     *
     * 驾驶证识别
     * @param bytes
     * @return
     */
    JSONObject drivingLicense(byte[] bytes);


    /***
     * 行驶证识别
     * @param file
     * @return
     */
    JSONObject vehicleLicense(String file);


    /***
     * 行驶证识别
     * @param bytes
     * @return
     */
    JSONObject vehicleLicense(byte[] bytes);


    /***
     * 车牌识别
     * @param file
     * @return
     */
    JSONObject plateLicense(String file);


    /***
     * 车牌识别
     * @param bytes
     * @return
     */
    JSONObject plateLicense(byte[] bytes);


    /***
     * 营业执照识别
     * @param file
     * @return
     */
    JSONObject businessLicense(String file);


    /***
     * 营业执照识别
     * @param bytes
     * @return
     */
    JSONObject businessLicense(byte[] bytes);


    /***
     * 二维码识别
     * @return
     */
    JSONObject generalUrl(String url);


    /***
     * 二维码识别
     * @return
     */
    JSONObject generalUrl(String url, HashMap<String, String> options);
}
