package com.core.algorithm;

import java.util.Map;

/**
 * @author dc.yuan
 * @version 1.0
 * @date 2022-10-18 19:39
 */
public class LRUTest {
    public static void main(String [] args){
        Map lru = new LinkedHashMapLRU(6,0.75f,true);
        lru.put("1","1");
        lru.put("2","2");
        lru.put("3","3");
        lru.put("4","4");
        lru.put("5","5");
        lru.put("6","6");
  /*     lru.forEach((k,v)->{
           System.out.println("k="+k+" v="+v);
       });*/
        lru.put("2","2");
        lru.put("3","3");
        lru.put("4","4");
        lru.put("6","6");
        lru.put("6","6");
        lru.put("4","4");
        lru.forEach((k,v)->{
            System.out.println("k="+k+" v="+v);
        });
    }
}
