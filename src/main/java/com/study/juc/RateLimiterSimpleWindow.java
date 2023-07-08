package com.study.juc;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 固定窗口限流，工具类
 *
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-04 14:53
 */
public class RateLimiterSimpleWindow {
    // 限流的阀值
    private static int QPS = 2;
    // 时间窗口(毫秒)
    private static long TIME_WINDOWS = 1000;
    // 原子类计数器
    private static AtomicInteger REQ_COUNT = new AtomicInteger(0);
    // 起始时间
    private static long START_TIME = System.currentTimeMillis();

    public synchronized static boolean tryAcquire() {
        if ((System.currentTimeMillis() - START_TIME) > TIME_WINDOWS) {
            REQ_COUNT.set(0);
            START_TIME = System.currentTimeMillis();
        }
        return REQ_COUNT.incrementAndGet() <= QPS;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            LocalTime now = LocalTime.now();
            if (!tryAcquire()) {
                System.out.println(now + " 被限流");
            } else {
                System.out.println(now + " 做点什么");
            }
        }
    }
}