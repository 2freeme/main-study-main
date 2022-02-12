package com.study.empty.leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： Dingpengfei
 * @Description： 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * @Date： 2021/5/5 13:10
 */
public class Test7 {

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        System.out.println(test7.reverse(121));
        System.out.println("2  " + test7.isPalindrome(-121));
        System.out.println(test7.longestCommonPrefixLess(new String[]{"abc", "abdc", "abdgdfgdfgd"}));
        System.out.println(test7.isValid("(){}[]"));
        System.out.println();

        System.out.println("1234".substring(2,4));
        int c = "ab".charAt(0);
        System.out.println(c);
        System.out.println(test7.lengthOfLongestSubstring("abcb"));
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {

        //利用除数来计算
        long rever = 0;
        while (x != 0) {
            rever = rever * 10 + x % 10;
            x = x / 10;
        }
        int re;
        re = (int) (rever) == rever ? (int) rever : 0;
        //因为这里强转会导致精度的不准
        return re;
    }


    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int source = x;
        long rever = 0;
        while (x > 0) {
            rever = rever * 10 + x % 10;
            x = x / 10;
        }
        int re;
        re = (int) (rever) == rever ? (int) rever : 0;
        //因为这里强转会导致精度的不准
        return re == source;
    }


    /**
     * 14. 最长公共前缀
     * 利用第一个的字符串就行按个的进行对比，然后进行优化
     *
     * @param
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();

        int length = strs.length;
        List<char[]> list = new ArrayList<>(length);
        if (length == 1) return strs[0];
        for (int i = 0; i < length; i++) {
            list.add(strs[i].toCharArray());
        }


        for (int i = 0; i < list.get(0).length; i++) {
            char a = list.get(0)[i];
            for (int j = 1; j < list.size(); j++) {
                char[] chars = list.get(j);
                if (chars.length > i && a == chars[i]) {
                    if (j == list.size() - 1)
                        builder.append(a);
                } else {
                    return builder.toString();
                }
            }
        }

        return builder.toString();
    }

    /**
     * 解法2
     * 利用字符串的startwith进行对比
     */
    public String longestCommonPrefixLess(String[] strs) {

        String first = strs[0];
        for (String str : strs) {
            while (!str.startsWith(first)) {
                if (first.length() == 0) return "";
                first = first.substring(0, first.length() - 1);
            }
        }
        return first;

    }

    /**
     * 有效的括号
     */
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) return false;

        int i = 1;
        //第一种情况对称
        while (true) {
            if (!istrue(s.substring(i-1,i),s.substring(length-i,length-i+1)))
                break;
            if (i == length/2)
                return true;
            i++;
        }

        //第二种情况 2个一起
        i=0;
        while (true) {
            if (!istrue(s.substring(i,i+1),s.substring(i+1,i+2)))
                break;
            if (i ==length-2)
                return true;
            i+=2;
        }
        return false;

    }

    private boolean istrue(String a, String b) {
        if (a.equals("(") && b.equals(")")) return true;
        if (a.equals("{") && b.equals("}")) return true;
        if (a.equals("[") && b.equals("]")) return true;

        return false;
    }


    public boolean isValid2(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }

    /**
     *
     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    /**
     *给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums   124  3
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

       int a =  nums.length;
        for (int i = 0; i < a; i++) {
            if (nums[i]>= target)
                return i;
        }
        return a;
    }

    /**
     * er fenfa
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length;
        while (left<right){
            int i = (left +right-1) /2;
            if (nums[i]<target){
                left ++;
            }else if (nums[i]>target){
                right --;
            }else{
                return i;
            }
        }
        return left;
    }


}
