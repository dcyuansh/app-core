package com.study.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-10-24 16:54
 * <p>
 * 场景2 让单个线程等待：多个线程(任务)完成后，进行汇总合并
 * 很多时候，我们的并发任务，存在前后依赖关系；比如数据详情页需要同时调用多个接口获取数据，并发请求获取到数据后、需要进行结果合并；或者多个数据操作完成后，需要数据check；这其实都是：在多个线程(任务)完成后，进行汇总合并的场景。
 */
public class T04_CountDownLatchDemo_02 {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("finish" + index + Thread.currentThread().getName());
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "线程1").start();
        }

        try {
            countDownLatch.await();// 主线程在阻塞，当计数器==0，就唤醒主线程往下执行。
            System.out.println("主线程:在所有任务运行完成后，进行结果汇总");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
