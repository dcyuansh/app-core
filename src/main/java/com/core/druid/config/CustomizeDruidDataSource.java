/*
package com.core.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

*/
/**
 * @author spring.yuan
 * @version 1.0
 *//*

public class CustomizeDruidDataSource extends DruidDataSource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private boolean lastInited;
    private String backupUrl;
    private String backupUsername;
    private String backupPassword;

    public String getBackupUrl() {
        return backupUrl;
    }

    public void setBackupUrl(String backupUrl) {
        this.backupUrl = backupUrl;
    }

    public String getBackupUsername() {
        return backupUsername;
    }

    public void setBackupUsername(String backupUsername) {
        this.backupUsername = backupUsername;
    }

    public String getBackupPassword() {
        return backupPassword;
    }

    public void setBackupPassword(String backupPassword) {
        this.backupPassword = backupPassword;
    }

    @Override
    public void init() throws SQLException {
        lastInited = inited;
        super.init();
        if (!lastInited && inited) {
            new Thread(new ValidateUrlTask()).start();
        }
    }

    class ValidateUrlTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                // 如果这个数据源被关闭了,就结束这个定时任务
                if (isClosed()) {
                    break;
                }
                //如果这个数据源已经被初始化了,同时连接异常才进行处理
                if (isInited() && isFailContinuous()) {
                    Connection connection = null;
                    try {
                        connection = DriverManager.getConnection(backupUrl, backupUsername, backupPassword);
                        jdbcUrl = backupUrl;
                        username = backupUsername;
                        password = backupPassword;
                    } catch (Exception ignored) {
                    } finally {
                        try {
                            connection.close();
                        } catch (Exception ignored) {
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}

*/
