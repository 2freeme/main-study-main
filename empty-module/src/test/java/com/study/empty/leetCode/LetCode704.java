package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei 二分查找
 * @Description：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class LetCode704 {

    @Test
    public void test2() {
        int search = search(new int[]{ 5}, 5);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {

        return getindex(nums, target, nums.length - 1, 0);

    }

    private int getindex(int[] nums, int target, int end, int start) {
        if (end <= start) {
            int dex = nums[start] == target ? start : -1;
            return dex;

        }
        int mid = (end - start) / 2 + start;
        if (mid <= start || mid >= end) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target)
                return end;
            return -1;
        }
        if (nums[mid] > target) {
            end = mid;
        } else if (nums[mid] < target) {
            start = mid;
        } else {
            return mid;
        }
        return getindex(nums, target, end, start);
    }
}
