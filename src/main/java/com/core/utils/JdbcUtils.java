package com.core.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author DC Yuan
 * @version 1.0
 */
public class JdbcUtils {

    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动
    public static String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test"; // 连接服务器和数据库test
    public static String dbname = "sa"; // 默认用户名
    public static String dbpassword = "123456"; // 密码

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dbURL, dbname, dbpassword);
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
