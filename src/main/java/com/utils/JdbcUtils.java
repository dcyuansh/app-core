package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author DC Yuan
 * @since 2020-02-08
 */
public class JdbcUtils {

    /**
     * 加载JDBC驱动
     */
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    /**
     * 连接服务器和数据库test
     */
    public static String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test";
    /**
     * 默认用户名
     */
    public static String dbName = "sa";
    /**
     * 密码
     */
    public static String dbPassword = "123456";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dbURL, dbName, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
