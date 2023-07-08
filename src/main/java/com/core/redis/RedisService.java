package com.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @author DC Yuan
 * @version 1.0
 */
@Component
public class RedisService {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param key
     * @param value
     * @return
     * @desc 写入缓存
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param key
     * @param value
     * @return
     * @desc 写入缓存设置时效时间
     */
    public boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param keys
     * @desc 批量删除对应的value
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * @param pattern
     * @desc 批量删除key
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * @param key
     * @desc 删除对应的value
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * @param key
     * @return
     * @desc 判断缓存中是否有对应的value
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * @param key
     * @return
     * @desc 读取缓存
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * @param key
     * @param hashKey
     * @param value
     * @desc 哈希 添加
     */
    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    /**
     * @param key
     * @param hashKey
     * @return
     * @desc 哈希获取数据
     */
    public Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * @param k
     * @param v
     * @desc 列表添加
     */
    public void lPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * @param k
     * @param l
     * @param l1
     * @return
     * @desc 列表获取
     */
    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    /**
     * @param key
     * @param value
     * @desc 集合添加
     */
    public void add(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * @param key
     * @return
     * @desc 集合获取
     */
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * @param key
     * @param value
     * @param scoure
     * @desc 有序集合添加
     */
    public void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     * @desc 有序集合获取
     */
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }


    /**
     * @param key
     * @return 当前队列的长度
     * @desc 指定 list 从左入栈
     */
    public Long leftPush(String key, Object value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }


    /**
     * @param key
     * @return 出栈的值
     * @desc 指定 list 从左出栈 如果列表没有元素,会堵塞到列表一直有元素或者超时为止
     */
    public Object leftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }
}

