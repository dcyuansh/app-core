package com.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author spring
 * @version 1.0
 */
public class MatcherUtils {


    /***
     * 验证是不是有效的身份证号
     * @param certNo
     * @return
     */
    public static boolean isIDCard(String certNo) {
        return ValidateIDCardUtils.isIDCard(certNo);
    }


    /****
     *
     * @param （6-16位数字和字母和特殊字符的组合）
     * @return
     */
    public static boolean isValidPassword(String password) {
        if (StringUtils.isBlank(password)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)(?![@$#]+$)[0-9A-Za-z@$#]{6,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


    /****
     * tel 11位,1开头，第二位(3,4,5,7,8)
     * @param tel
     * @return
     */
    public static boolean isValidTel(String tel) {
        if (StringUtils.isBlank(tel)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
        Matcher matcher = pattern.matcher(tel);
        return matcher.matches();
    }


    /***
     * 是否为16-22位银行账号
     * @param bankAccount
     * @return
     */
    public static boolean isBankAccount(String bankAccount) {
        if (StringUtils.isBlank(bankAccount)) {
            return false;
        }
        return bankAccount.matches("^\\d{16,22}$");
    }


    /***
     * 是否是纯数字，不含空格
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        int size = str.length();
        for (int i = 0; i < size; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    /***
     * 是否数值类型，整数或小数
     * @param str
     * @return
     */
    public static boolean isNumericalValue(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return str.matches("^[+-]?(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d)+)?$");
    }


    /**
     * 判断是不是中文字符串
     *
     * @param cn
     * @return
     */
    public static boolean isCNStr(String cn) {
        if (StringUtils.isBlank(cn)) {
            return false;
        }
        return cn.matches("^[\\u4e00-\\u9fa5]{0,}$");
    }
}
