package com.study.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-10-24 11:05
 * <p>
 * 多线程按照顺序输出1A2B3C4D。。。。26Z
 */
public class T03_LockSupport {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] number = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] letter = "ABCDEFGH".toCharArray();

        t1 = new Thread(() -> {
            try {
                for (int i = 0; i < number.length; i++) {
                    Thread.sleep(10);
                    System.out.print(number[i]);
                    LockSupport.unpark(t2);  //叫醒t2
                    LockSupport.park(); //阻塞t1
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "线程1");

        t2 = new Thread(() -> {
            try {
                for (int i = 0; i < letter.length; i++) {
                    LockSupport.park(); //阻塞
                    System.out.print(letter[i]);
                    LockSupport.unpark(t1); //叫醒t1
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "线程2");

        t1.start();
        t2.start();
    }
}


