package com.study.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-03 14:44
 */
public class SelectionSort {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        int[] result = sort.sort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(result));
    }
}
