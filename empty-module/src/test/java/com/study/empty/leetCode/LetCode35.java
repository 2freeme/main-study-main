package com.study.empty.leetCode;

import com.vladium.jcd.cls.IFieldCollection;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Date： 2022/3/9 14:31
 */
public class LetCode35 {

    @Test
    public void test2() {
        int i = searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        if (nums[end] <target)//处理边界值的问题
            start=end+1;
        return start;
    }

    //正确解法
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1; // 注意
            while(left <= right) { // 注意
                int mid = (left + right) / 2; // 注意
                if(nums[mid] == target) { // 注意
                    // 相关逻辑
                } else if(nums[mid] < target) {
                    left = mid + 1; // 注意
                } else {
                    right = mid - 1; // 注意
                }
            }
            // 相关返回值
            return 0;
        }
    }


}
