package com.study.algorithm;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-10-18 19:39
 */
public class LRUTest {
    public static void main(String[] args) {
        //Map lru = new LinkedHashMapLRUCache(6,0.75f,true);
        LRUCache lru = new LRUCache(6);
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.put("4", "4");
        lru.put("5", "5");
        lru.put("6", "6");

        lru.put("8", "8");
        lru.put("6", "6");

    /*    lru.getCache().forEach((k,v)->{
            System.out.println("k="+k+" v="+v.value);
        });*/

        LRUCache.LRULinkNode synode = lru.getTail().pre;
        while (synode.pre != null) {
            System.out.println("k=" + synode.key + " v=" + synode.value);
            synode = synode.pre;
        }
    }
}
