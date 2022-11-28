package com.study.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-10-24 11:05
 * <p>
 * 多线程按照顺序输出1A2B3C4D。。。。26Z
 */
public class T02_ReentrantLock {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        char[] letter = "ABCDEFGH".toCharArray();
        char[] number = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};

        Lock lock = new ReentrantLock();
        Condition conditionT1 = lock.newCondition(); //队列1
        Condition conditionT2 = lock.newCondition(); //队列2

        new Thread(() -> {
            try {
                Thread.sleep(10);
                lock.lock();
                for (int i = 0; i < number.length; i++) {
                    System.out.print(number[i]);
                    countDownLatch.countDown();  //打开门闩
                    conditionT2.signal(); //通知第二个队列
                    conditionT1.await(); //阻塞
                }
                conditionT2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程1").start();


        new Thread(() -> {
            try {
                countDownLatch.await();  //等待
                lock.lock();
                for (int i = 0; i < letter.length; i++) {
                    System.out.print(letter[i]);
                    conditionT1.signal();
                    conditionT2.await();
                }
                conditionT1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "线程2").start();
    }
}

