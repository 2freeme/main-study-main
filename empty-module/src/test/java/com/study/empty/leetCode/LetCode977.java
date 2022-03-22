package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author： Dingpengfei
 * @Description： 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * @Date： 2022/3/10 23:49
 */
public class LetCode977 {

    @Test
    public void test2() {
        int[] i = sortedSquares2(new int[]{-7,-3,2,3,11});
        System.out.println(JSONObject.toJSON(i));
    }

    public int[] sortedSquares(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i] * nums[i];
        }
        Arrays.sort(sum);
        return sum;
    }


    /**
     * 双指针的问题，因为本身就是双向的排序
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        int[] sum = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int count = nums.length - 1;
        while (left <= right) {
            if (nums[left]*nums[left]> nums[right]*nums[right]) {
                sum[count] = nums[left]*nums[left];
                left++;
            } else {
                sum[count] = nums[right]*nums[right];
                right--;
            }
            count--;
        }
        return sum;
    }
}
