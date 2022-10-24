package com.study.algorithm;

import java.util.Scanner;

/**
 * 算法题：给定一个数组代表股票每天的价格，请问只能买卖一次的情况下，最大化利润是多少？
 * 输入: {100, 80, 120, 130, 70, 60, 100, 125}
 * 输出:65（60 买进，125 卖出）
 */
public class MaxiDifference {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        if (sc.hasNext()) {
            input = sc.nextLine();
        }
        String[] inputArry = input.split(",");
        int len = inputArry.length;
        int[] intArry = new int[len];
        for (int i = 0; i < len; i++) {
            intArry[i] = Integer.valueOf(inputArry[i]);
        }
        maxProfit(intArry);
    }


    public static void maxProfit(int[] array) {
        int result = 0;
        if (array.length == 0) {
            System.out.println(0);
        }
        int max = array[0];
        int min = array[0];
        int max_index = 0;
        int min_index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= min) {
                min = array[i];
                min_index = i;
            } else if (array[i] >= max || (max_index <= min_index)) {
                max = array[i];
                max_index = i;
            }
            if (max_index >= min_index) {
                int tem = max - min;
                result = result >= tem ? result : tem;
            }
        }
        System.out.println(result);
    }
}
