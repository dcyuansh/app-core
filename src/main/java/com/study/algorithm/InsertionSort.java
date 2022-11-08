package com.study.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-03 14:51
 */
public class InsertionSort {


    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i-1;    //
            int current = arr[i];  //当前值
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        System.out.println("排序前的数组: " + Arrays.toString(arr));
        int[] result = sort.sort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(result));
    }
}
