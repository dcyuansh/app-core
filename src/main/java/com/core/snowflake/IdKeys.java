package com.core.snowflake;

import com.core.utils.IpUtils;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * @author spring.yuan
 * @version 1.0
 * @desc 采用雪花算法生成主键id
 */
@Configuration
public class IdKeys {

    /**
     * 机器id,数据中心id最大值
     */
    private static int DATA_MAX_NUM = 31;

    /**
     * 设置默认的机器id
     */
    private static int DEFAULT_WORK_ID = 5;

    /**
     * 设置默认的数据中心id
     */
    private static int DEFAULT_DATA_CENTER_ID = 5;

    /**
     * 初始化雪花算法对象
     */
    private static SnowflakeIdWorker SNOWFLAKE_ID_WORKER = new SnowflakeIdWorker(getWorkId(), getDataCenterId());


    /**
     * @return 返回主键id
     * @desc 返回generate id
     */
    public Long nextId() {
        return SNOWFLAKE_ID_WORKER.nextId();
    }


    /**
     * @return 返回机器id，0到31之间
     * @desc 根据host name 取余，发生异常就获取0到31之间的随机数
     */
    public static int getWorkId() {
        try {
            return getHostId(IpUtils.getHostIp().replaceAll("\\.", ""), DATA_MAX_NUM);
        } catch (UnknownHostException e) {
            return DEFAULT_WORK_ID;
        }
    }

    /**
     * @return 返回数据中id，0到31之间
     * @desc 根据host name 取余，发生异常就获取0到31之间的随机数
     */
    public static int getDataCenterId() {
        try {
            return getHostId(IpUtils.getHostIp().replaceAll("\\.", ""), DATA_MAX_NUM);
        } catch (UnknownHostException e) {
            return DEFAULT_DATA_CENTER_ID;
        }
    }

    /**
     * @return 返回取余后的数字
     * @desc 根据host ip取余
     */
    private static int getHostId(String s, int max) {
        byte[] bytes = s.getBytes();
        int sums = 0;
        for (byte b : bytes) {
            sums += b;
        }
        return sums % (max + 1);
    }
}
