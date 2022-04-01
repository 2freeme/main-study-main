package com.study.empty.leetCode;

import com.kenai.jaffl.annotations.In;
import org.junit.Test;

import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * @Date： 2022/3/31 21:42
 */
public class LetCode53 {
    @Test
    public void test2() {
        Stack<String> strings = new Stack<>();
        String i = "){";
        int[] nums = {5, 4, -1, -7, 8};
        System.out.println(maxSubArray2(nums));
    }

    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int sum =0;
        for (int num : nums) {
            if (sum <0){
                sum = Math.max(num ,sum);
            }else{
                sum+=num;
            }
            max= Math.max(sum,max);
        }
        return max;
    }
        /**
         * 时长太长了。理论上是对的多了很多的无用的计算
         * @param nums
         * @return
         */
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0) continue;
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j]<0)continue;
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
