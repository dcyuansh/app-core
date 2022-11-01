package com.study.algorithm;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断该字符串是否有效。
 * 有效字符串需满足：
 * 1: 左括号必须用相同类型的右括号闭合。
 * 2: 左括号必须以正确的顺序闭合。
 * 比如 "()"、"()[]{}"、"{[]}" 都是有效字符串，而 "(]" 、"([)]" 则不是。
 */
public class StackValidStr {

    /**
     * 首先我们将括号间的对应规则存放在 Map 中，这一点应该毋容置疑；
     * 创建一个栈。遍历字符串，如果字符是左括号就直接加入stack中，
     * 否则将stack 的栈顶元素与这个括号做比较，
     * 如果不相等就直接返回 false。遍历结束，如果stack为空，返回 true。
     *
     * @return
     */
    public boolean validStr(String str) {
        // 括号之间的对应规则
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        //创建栈
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (mappings.containsKey(chars[i])) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(chars[i])) {
                    return false;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        StackValidStr validStr = new StackValidStr();
        //测试一: true
        System.out.println(validStr.validStr("[{()}]"));
        //测试二: true
        System.out.println(validStr.validStr("[](){}"));
        //测试三: false
        System.out.println(validStr.validStr("[(}){}]"));
    }
}
