package com.study.empty.leetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date： 2022/3/31 17:07
 */
public class LetCode20 {
    @Test
    public void test2() {
        Stack<String> strings = new Stack<>();
        String i = "){";
        System.out.println(isValid(i));
    }

    /**
     * 单调栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length%2 !=0)return false;
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == ')' ) {
                if (stack.empty() || stack.pop() != '(') return false;
            } else if (aChar == '}') {
                if (stack.empty() || stack.pop()!= '{') return false;
            } else if (aChar == ']') {
                if (stack.empty() || stack.pop() != '[') return false;
            }else{
                stack.push(aChar);
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
