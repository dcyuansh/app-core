package com.study.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-10-24 16:54
 * <p>
 * 场景1 让多个线程等待：模拟并发，让并发线程一起执行
 * 为了模拟高并发，让一组线程在指定时刻(秒杀时间)执行抢购，这些线程在准备就绪后，进行等待(CountDownLatch.await())，直到秒杀时刻的到来，然后一拥而上。这也是本地测试接口并发的一个简易实现。
 * 在这个场景中，CountDownLatch充当的是一个发令枪的角色；就像田径赛跑时，运动员会在起跑线做准备动作，等到发令枪一声响，运动员就会奋力奔跑。和上面的秒杀场景类似。
 */
public class T04_CountDownLatchDemo_01 {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();  //等待
                    System.out.println(Thread.currentThread().getName() + "正在执行.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "线程1").start();
        }

        countDownLatch.countDown();  //开始
    }
}
