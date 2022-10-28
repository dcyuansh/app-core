package com.study.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-10-25 16:19
 */
public class CompareAndSet_01 {

    public static void main(String[] args) {
        //测试1 AtomicInteger
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println("atomicInteger-" + atomicInteger.compareAndSet(5, 10) + "--" + atomicInteger);
        System.out.println("atomicInteger-" + atomicInteger.compareAndSet(10, 5) + "--" + atomicInteger);
        System.out.println("atomicInteger-" + atomicInteger.compareAndSet(5, 20) + "--" + atomicInteger);

        //测试2 AtomicReference
        AtomicReference atomicReference = new AtomicReference(5);
        System.out.println("atomicReference-" + atomicReference.compareAndSet(5, 10) + "--" + atomicReference);
        System.out.println("atomicReference-" + atomicReference.compareAndSet(10, 5) + "--" + atomicReference);
        System.out.println("atomicReference-" + atomicReference.compareAndSet(5, 20) + "--" + atomicReference);

        //测试3 AtomicStampedReference
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(5, 1);
        int stamp = atomicStampedReference.getStamp();
        System.out.println("stamp= " + atomicStampedReference.getStamp());
        System.out.println("atomicStampedReference-" + atomicStampedReference.compareAndSet(5, 10, stamp, stamp + 1) + "--" + atomicStampedReference.getReference());
        System.out.println("atomicStampedReference-" + atomicStampedReference.compareAndSet(10, 5, stamp, stamp + 1) + "--" + atomicStampedReference.getReference());
        System.out.println("atomicStampedReference-" + atomicStampedReference.compareAndSet(5, 20, stamp, stamp + 1) + "--" + atomicStampedReference.getReference());
        System.out.println("stamp= " + atomicStampedReference.getStamp());
    }
}
