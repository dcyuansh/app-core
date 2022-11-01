package com.study.algorithm;

import java.util.Arrays;

/**
 * Leetcode: 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class StringSub {

    /**
     * 思路很简单！先利用Arrays.sort(strs)为数组排序，
     * 再将数组第一个元素和最后一个元素的字符从前往后对比即可！
     *
     * @param strs
     * @return
     */
    public String subCommStr(String[] strs) {
        //校验
        if (!checkStr(strs)) {
            return "";
        }
        //数组长度
        int len = strs.length;
        //保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);
        //排序后第一个字符串的长度
        int f = strs[0].length();
        //排序后最后一个字符串的长度
        int e = strs[len - 1].length();
        //得到第一个字符串和最后一个字符串中最小的长度
        int num = Math.min(f, e);
        //循环这两个字符串找出相同的字符，添加到res中去
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return res.toString();
    }

    //校验字符数组合规性
    public boolean checkStr(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            //遍历strs元素
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }


    // 测试
    public static void main(String[] args) {
        StringSub sub = new StringSub();

        String[] strs = {"caustomer", "car", "cat"};
        //String[] strs = { "customer", "car", null };//空串
        // String[] strs = {};//空串
        // String[] strs = null;//空串
        System.out.println("相同字符串: " + sub.subCommStr(strs));// c
    }
}
