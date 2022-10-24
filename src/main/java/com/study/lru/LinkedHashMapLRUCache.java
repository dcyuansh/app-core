package com.study.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dc.yuan
 * @version 1.0
 * @date 2022-10-18 19:28
 * 基于LinkHashMap实现LRU算法
 */
public class LinkedHashMapLRUCache extends LinkedHashMap<String, String> {

    private final  int initialCapacity;


    public LinkedHashMapLRUCache(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        this.initialCapacity = initialCapacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return this.size() >= this.initialCapacity;
    }
}
