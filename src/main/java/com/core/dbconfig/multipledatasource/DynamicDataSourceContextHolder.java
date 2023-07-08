package com.core.dbconfig.multipledatasource;

/**
 * @author DC Yuan
 * @version 1.0
 */
public class DynamicDataSourceContextHolder {

    /**
     * 线程独立
     */
    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static DataSourceType getDataSourceType() {
        DataSourceType dataSourceType = contextHolder.get() == null ? DataSourceType.MASTER : contextHolder.get();
        return dataSourceType;
    }

    public static void setDataSourceType(DataSourceType dataSourceType) {
        if (dataSourceType == null) throw new NullPointerException("未设置数据源");
        contextHolder.set(dataSourceType);
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
