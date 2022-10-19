package com.core.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * @author dc.yuan
 * @version 1.0
 * @date 2022-10-18 19:28
 * LRU(Least recently used，最近最少使用算法)
 */
public class LRUCache {
    class LRULinkNode {
        String key;
        String value;
        LRULinkNode pre;
        LRULinkNode post;
    }

    private Map<String, LRULinkNode> cache = new HashMap<String, LRULinkNode>();
    private int count;
    private int capacity;
    private LRULinkNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new LRULinkNode();
        head.pre = null;

        tail = new LRULinkNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public String get(String key) {
        LRULinkNode node = cache.get(key);
        if (node == null) {
            return "-1";
        }
        //移动到链表头部去
        moveToHead(node);
        return node.value;
    }

    public void put(String key, String value) {
        LRULinkNode node = cache.get(key);
        //如果是cache中存在的node
        if (node != null) {
            node.value = value;
            //如果是存在的链表node节点，则移动链表街道到链表头部
            moveToHead(node);
            return;
        }
        //如果是cache中不存在的node
        LRULinkNode newNode = new LRULinkNode();
        newNode.key = key;
        newNode.value = value;

        //添加新node节点到cache map中去
        cache.put(key, newNode);
        //添加新node节点到链表头部去
        addNode(newNode);

        //记录链表中数据容量
        ++count;

        //如果链表中的数据超过了容量大小，则删除链表尾部数，删除map中对应的数据。
        if (count > capacity) {
            LRULinkNode tail = popTail();
            cache.remove(tail.key);
            --count;
        }
    }


    /**
     * 删除node节点
     *
     * @param node
     */
    private void removeNode(LRULinkNode node) {
        LRULinkNode pre = node.pre;
        LRULinkNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * 将node节点移到链表最前面去，实现方法：先删除，在加入
     */
    private void moveToHead(LRULinkNode node) {
        //删除链表节点
        removeNode(node);
        //添加链表节点
        addNode(node);
    }

    /**
     * 添加新的node节点到链表头部(head节点后面)
     *
     * @param node
     */
    private void addNode(LRULinkNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * 移除链表中最后的node节点
     *
     * @return
     */
    private LRULinkNode popTail() {
        //获取队列链表中最后的node节点
        LRULinkNode res = tail.pre;
        //移除链表中最后的node节点
        removeNode(res);
        return res;
    }

    public Map<String, LRULinkNode> getCache() {
        return cache;
    }

    public void setCache(Map<String, LRULinkNode> cache) {
        this.cache = cache;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LRULinkNode getHead() {
        return head;
    }

    public void setHead(LRULinkNode head) {
        this.head = head;
    }

    public LRULinkNode getTail() {
        return tail;
    }

    public void setTail(LRULinkNode tail) {
        this.tail = tail;
    }
}
