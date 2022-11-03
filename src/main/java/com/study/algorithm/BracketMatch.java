package com.study.algorithm;

import java.util.Scanner;

/**
 * 例如: "()()()"的深度是1,"((()))"的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
 * <p>
 * 输入描述:
 * 输入包括一个合法的括号序列s,s长度length(2 ≤ length ≤ 50),序列中只包含'('和')'。
 * <p>
 * 输出描述:
 * 输出一个正整数,即这个序列的深度。
 * <p>
 * 示例：
 * <p>
 * 输入: (())
 * 输出: 2
 *
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-02 17:53
 */
public class BracketMatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt = 0, mas = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            mas = Math.max(mas, cnt);
        }
        sc.close();
        System.out.println("括号的最大深度: " + mas);
    }
}
