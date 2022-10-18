package com.core.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dc.yuan
 * @version 1.0
 * @date 2022-10-18 19:28
 * @desc 基于LinkHashMap实现LRU算法
 */
public class LinkedHashMapLRU extends LinkedHashMap<String, String> {

    private int initialCapacity;


    public LinkedHashMapLRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        this.initialCapacity = initialCapacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return this.size() >= initialCapacity;
    }
}
