package com.study.algorithm;

/**
 * 剑指offer: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-03 11:25
 */
public class ConvertStrToInt {

    public int strToInt(String src) {
        if (src.length() == 0) return 0;

        char[] inputStr = src.toCharArray();
        //判断是否存在符号
        int flag = 0;
        if (inputStr[0] == '-') {
            flag = 1;
        } else if (inputStr[0] == '+') {
            flag = 2;
        }
        //计算转换开始下标，如果有符号位就从1开始
        int startIndex = flag > 0 ? 1 : 0;
        //返回结果
        int result = 0;
        for (int i = startIndex; i < inputStr.length; i++) {
            if (Character.isDigit(inputStr[i])) {
                int temp = inputStr[i] - '0';
                result = 10 * result + temp;
            } else {
                return 0;
            }
        }
        return flag == 1 ? -result : result;
    }

    public static void main(String[] args) {
        ConvertStrToInt strToInt = new ConvertStrToInt();
        String inputStr = "-12312312";
        System.out.println("使用库函数转换：" + Integer.valueOf(inputStr));
        int res = strToInt.strToInt(inputStr);
        System.out.println("使用自己写的方法转换：" + res);
    }
}
