package com.study.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author dc.yuan
 * @version 1.0
 * @date 2022-10-24 11:05
 * <p>
 * 多线程按照顺序输出1A2B3C4D。。。。26Z
 */
public class T01_Synchronized {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        char[] letter = "ABCDEFGH".toCharArray();
        char[] number = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};

        final Object obj = new Object();

        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (obj) {
                for (int i = 0; i < number.length; i++) {
                    try {
                        System.out.print(number[i]);
                        countDownLatch.countDown();
                        obj.notify(); //唤醒第二个线程
                        obj.wait(); //阻塞
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }, "线程1").start();


        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (obj) {
                for (int i = 0; i < letter.length; i++) {
                    try {
                        System.out.print(letter[i]);
                        obj.notify();
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }, "线程2").start();
    }


}

