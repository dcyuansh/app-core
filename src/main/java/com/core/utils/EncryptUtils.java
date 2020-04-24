package com.core.utils;

import com.core.enums.EncodeTypeEnum;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;


/**
 * @author dechun.yuan
 * @version 1.0
 */
public class EncryptUtils {

    private static final String SALT = "Use MD5 Encryption";

    /***
     * MD5 encode
     * @param str
     * @return
     */
    public static String encodeByMd5(String str) {
        str = str + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


    /***
     * base64 encode
     * @param str
     * @return
     */
    public static String encodeByBase64(String str, String encodeType) {
        if (str == null) return null;
        Encoder encoder = Base64.getEncoder();
        byte[] bt = null;
        try {
            bt = str.getBytes(encodeType == null ? EncodeTypeEnum.UTF8.getEncodeType() : encodeType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encoder.encodeToString(bt);
    }


    /***
     * base64 decode
     * @param str
     * @return
     */
    public static String decodeByBase64(String str, String encodeType) {
        if (str == null) return null;
        Decoder decoder = Base64.getDecoder();
        byte[] asBytes = decoder.decode(str);
        String decodeStr = null;
        try {
            decodeStr = new String(asBytes, encodeType == null ? EncodeTypeEnum.UTF8.getEncodeType() : encodeType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodeStr;
    }
}
