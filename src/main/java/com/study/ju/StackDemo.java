package com.study.ju;

import java.util.Stack;

/**
 * @author DC Yuan
 * @version 1.0
 * @date 2022-11-01 15:33
 */
public class  StackDemo {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A1");
        stack.push("A2");
        stack.push("A3");
        stack.push("A4");
        stack.push("A5");

        //方法一: 只是遍历,先进先出
        for (String s : stack) {
            System.out.print(s);
        }
        System.out.println();
        System.out.println("--------");

        //方法二:  遍历逐一出栈，后进先出
        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}
