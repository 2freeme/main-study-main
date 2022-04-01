package com.study.empty.leetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 链接：https://leetcode-cn.com/problems/single-number
 * @Date： 2022/4/1 16:51
 */
public class LetCode136 {
    @Test
    public void test2() {
        Stack<String> strings = new Stack<>();
        String i = "){";
        int[] nums = {5, 5,2};
        System.out.println(singleNumber(nums));
    }


    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        for (Integer integer : set) {
            return integer;
        }
        return -1;
    }
}
