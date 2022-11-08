package com.study.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-03 14:11
 */
public class BubbleSort {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        int[] result = bubbleSort.sort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(result));
    }
}
