package com.study.empty.leetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date： 2022/4/20 22:27
 */
public class LetCode9 {

    @Test
    public void test2() {

        System.out.println(isPalindrome(11));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int length = s.length();
        int l = 0, r = length-1;
        while (l <= r){
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
