package com.study.empty.leetCode.middle.study;

/**
 * @Author： Dingpengfei
 * @Description：给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * @Date： 2022/6/14 23:40
 */
public class LetCode55 {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i+nums[i] == length){
                return true;
            }
        }
    }
}
