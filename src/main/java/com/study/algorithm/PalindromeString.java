package com.study.algorithm;

import java.util.HashSet;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-02 10:24
 */
public class PalindromeString {

    /**
     * LeetCode:给定一个包含大写字母和小写字母的字符串，
     * 找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。
     * 比如"Aa"不能当做一个回文字符串。
     * 注 意:假设字符串的长度不会超过 1010。
     *
     * @param str
     * @return
     */
    public int longestPalindrome(String str) {
        //校验字符串
        if (str.length() == 0) return 0;

        HashSet<Character> hashSet = new HashSet<>();
        char[] strChar = str.toCharArray();
        int resCount = 0;
        for (int i = 0; i < strChar.length; i++) {
            // 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
            if (hashSet.contains(strChar[i])) {
                hashSet.remove(strChar[i]);
                resCount++;
            } else {
                // 如果hashset没有该字符就保存进去
                hashSet.add(strChar[i]);
            }
        }
        return hashSet.isEmpty() ? 2 * resCount : 2 * resCount + 1;
    }


    /**
     * LeetCode: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * <p>
     * 输入: "race a car"
     * 输出: false
     *
     * @param str
     * @return
     */
    public boolean isPalindrome(String str) {
        if (str.length() == 0) return false;
        int l = 0, r = str.length() - 1;
        //从首尾两端同时遍历字符串，跳过字母和数字以外的字符，然后进行比较是否是相等
        while (l < r) {
            // 从头和尾开始向中间遍历
            if (!Character.isLetterOrDigit(str.charAt(l))) { // 字符不是字母和数字的情况
                l++;
            } else if (!Character.isLetterOrDigit(str.charAt(r))) { // 字符不是字母和数字的情况
                r--;
            } else {
                if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))) {
                    return false;
                }
                //移动下标，继续比较下一个字符
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeString palStr = new PalindromeString();
        //获取字符串能构成的最长回文串
        System.out.println("字符串能构成的最长回文串length:" + palStr.longestPalindrome("abccccdd"));
        //判断字符串是不是回文串
        System.out.println("字符串是不是回文串:" + palStr.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
