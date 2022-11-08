package com.study.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger做限流，计数器
 *
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-04 14:53
 */
public class RequestLimit_01 {
    // 限流的个数
    private int maxCount = 10;
    // 指定的时间内
    private long interval = 60;
    // 原子类计数器
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    // 起始时间
    private long startTime = System.currentTimeMillis();


    public boolean limit(int maxCount, int interval) {
        atomicInteger.addAndGet(1);
        if (atomicInteger.get() == 1) {
            startTime = System.currentTimeMillis();
            atomicInteger.addAndGet(1);
            return true;
        }
        // 超过了间隔时间，直接重新开始计数
        if (System.currentTimeMillis() - startTime > interval * 1000) {
            startTime = System.currentTimeMillis();
            //设置从1开始记数
            atomicInteger.set(1);
            return true;
        }
        // 还在间隔时间内,check有没有超过限流的个数
        if (atomicInteger.get() > maxCount) {
            return false;
        }
        return true;
    }
}
