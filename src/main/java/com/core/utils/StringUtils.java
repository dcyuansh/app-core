package com.core.utils;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dechun.yuan
 * @version 1.0
 */
public class StringUtils {

    private static final char UNDERLINE = '_';
    private static final String DELIMITER = ",";
    private static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";
    private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
    private static final double MAX_VALUE = 9999999999999.99D;


    /***
     * format filed name
     * @param columnName
     * @return
     */
    public static String formatFieldName(String columnName) {
        String resultColumnName;
        if (columnName == null) {
            resultColumnName = "";
        } else {
            //去掉下划线，转为驼峰命名法
            resultColumnName = underlineToCamel(columnName.trim());
        }
        return resultColumnName;
    }


    /**
     * translate value
     *
     * @param value
     * @return
     */
    public static Object translateValue(Object value) {
        Object resultObject = value;
        if (value instanceof String) {
            String strValue = (String) value;
            if (strValue == null || "".equals(strValue)) {
                resultObject = null;
            } else {
                //这里可以根据string格式，将string转换为对应的object
            }
        }
        return resultObject;
    }


    /***
     * 将字符串中的下划线(_)去掉，后面第一个字母大写
     * @param param
     * @return
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = Character.toLowerCase(param.charAt(i));
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    /***
     * 判断字符是否为空，空格、制表符、tab
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                // 判断字符是否为空格、制表符、tab
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }


    /***
     *　判断字符串不能为空，空格、制表符、tab
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }


    /***
     * 判断是否为空字符串,没有判断空格
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }


    /***
     * 判断字符串是否非空
     * @param str 如果不为空，则返回true
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }


    /***
     * 用map替换String中的值，替换key为values
     * @param str
     * @param map
     * @return
     */
    public static String replaceByMap(String str, Map<String, String> map) {
        String result = str;
        if (map == null || map.isEmpty()) {
            return result;
        }
        for (String _key : map.keySet()) {
            result = result.replace(_key, map.get(_key));
        }
        return result;
    }


    /***
     *  替换字符串，rep数值里面的值，为with
     * @param text
     * @param rep
     * @param with
     * @return
     */
    public static String replaceAll(String text, String[] rep, String with) {
        String result = text;
        for (int i = 0; i < rep.length; i++) {
            result = result.replace(rep[i], with);
        }
        return result;
    }


    /***
     * 将字符串，按照分隔符，拆分为字符串数组
     * @param value
     * @param delimiter
     * @return
     */
    public static String[] delimitedToArray(String value, String delimiter) {
        String[] list = null;
        if (value != null) {
            if (delimiter == null)
                delimiter = DELIMITER;
            StringTokenizer tok = new StringTokenizer(value, delimiter);
            list = new String[tok.countTokens()];
            int count = 0;
            while (tok.hasMoreTokens()) {
                String v = tok.nextToken();
                if (isNotEmpty(v)) {
                    list[count++] = v;
                }
            }
        }
        return list;
    }


    /***
     * 替换字符串，中的&key&，map中的values
     * @param content
     * @param map
     * @return
     */
    public static String replaceVariables(String content, Map<String, String> map) {
        if (isEmpty(content)) {
            return content;
        }
        Pattern quoteRegex = Pattern.compile("\\$\\w*\\$");
        Matcher quoteRegexMatcher = quoteRegex.matcher(content);
        while (quoteRegexMatcher.find()) {
            if (quoteRegexMatcher.group().length() > 1) {
                String variableName = quoteRegexMatcher.group().substring(1, quoteRegexMatcher.group().length() - 1);
                content = content.replace("$" + variableName + "$", map.get(variableName));
            }
        }
        return content;
    }


    /***
     * 将double钱转换为中文
     * @param v
     * @return
     */
    public static String convMonyToCHS(double v) {
        if (v < 0 || v > MAX_VALUE) {
            return "参数非法!";
        }
        long l = Math.round(v * 100);
        if (l == 0) {
            return "零元整";
        }
        String strValue = l + "";
        // i用来控制数
        int i = 0;
        // j用来控制单位
        int j = UNIT.length() - strValue.length();
        String rs = "";
        boolean isZero = false;
        for (; i < strValue.length(); i++, j++) {
            char ch = strValue.charAt(i);
            if (ch == '0') {
                isZero = true;
                if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万' || UNIT.charAt(j) == '元') {
                    rs = rs + UNIT.charAt(j);
                    isZero = false;
                }
            } else {
                if (isZero) {
                    rs = rs + "零";
                    isZero = false;
                }
                rs = rs + DIGIT.charAt(ch - '0') + UNIT.charAt(j);
            }
        }
        if (!rs.endsWith("分")) {
            rs = rs + "整";
        }
        rs = rs.replaceAll("亿万", "亿");
        return rs;
    }


    /***
     *  判断是不是中文字符
     * @param c
     * @return
     */
    public static boolean isChineseChar(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }


    /***
     * 判断是不是中文字符串
     * @param str
     * @return
     */
    public static boolean isChineseStr(String str) {
        boolean res = true;
        char[] cTemp = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (!isChineseChar(cTemp[i])) {
                res = false;
                break;
            }
        }
        return res;
    }


    /***
     * 判断字符串中是不是包含中文
     * @param str
     * @return
     */
    public static boolean containChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }


    /***
     * 去掉英文，只保留中文字符串
     * @param str
     * @return
     */
    public static String getCnStr(String str) {
        if (!StringUtils.isEmpty(str)) {
            String reg = "[^\u4e00-\u9fa5]";
            str = str.replaceAll(reg, "");
        }
        return str;
    }


    /***
     * 去掉中文，只保留英文字符串
     * @param str
     * @return
     */
    public static String getEnStr(String str) {
        if (!StringUtils.isEmpty(str)) {
            String reg = "[^a-zA-Z\\s+]";
            str = str.replaceAll(reg, "");
            str = str.trim();
            reg = "\\s{1,}";
            str = str.replaceAll(reg, " ");
        }
        return str;
    }
}
