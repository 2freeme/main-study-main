package com.study.empty.leetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Date： 2022/6/14 22:52
 */
public class LetCode169 {

    //核心的思想就是当确定了一定有过半数的时候，只需要一增一减，最后一次一定是大于的就行
    @Test
    public void test2() {

        int[] nums = {5, 4, -1, -7, 8, 1, 1, 1, 1,1,1};
        int length = majorityElement(nums);
        System.out.println(length);
        System.out.println(nums[0]++);
        System.out.println(nums[0]);
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        int start = 0, count = 1, sum = nums[0];
        while ( start < length-1) {
            start++;
            if (sum == nums[start]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    sum = nums[start];
                    count=1;
                }
            }

        }
        return sum;
    }

}
