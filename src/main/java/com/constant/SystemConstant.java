package com.constant;

/**
 * 系统常量实现类
 *
 * @author DC Yuan
 * @since 2020-02-08
 */
public final class SystemConstant {

    /**
     * API接口返回代码
     */
    public static final String RESULT_CODE = "code";
    public static final String RESULT_DATA = "data";
    public static final String RESULT_MESSAGE = "msg";
    public static final String RESULT_INFO = "info";

    /**
     * decimal format
     */
    public static final String DECIMAL_DEFAULT_FORMAT = "###,###,###,##0.00";

    /**
     * number format
     */
    public static final String NUMBER_FORMAT = "#,##0.00";

    /**
     * date format
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String LOCALE_CN_DATE_FORMAT = "yyyy MM dd";
    public static final String LOCALE_CN_DATE_TIME_FORMAT = "yyyy MM dd HH mm ss";
    public static final String DATE_LONG_FORMAT = "yyyyMMdd";
    public static final String DATE_TIME_LONG_FORMAT = "yyyyMMddHHmmss";
    public static final String LOCAL_TIME_LONG_FORMAT = "yyyyMMddHHmmssSSS";

    /**
     * page helper pagination设置默认当前页
     */
    public static final int PAGE_NUM = 1;
    /**
     * page helper pagination设置默认每页记录数量
     */
    public static final int PAGE_SIZE = 10;

}
