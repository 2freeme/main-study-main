package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * @Date： 2022/3/11 0:25
 */
public class LetCode189 {

    @Test
    public void test2() {
        rotate(new int[]{1,2,3,4,5,6,7,8},3);

    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] sum = new int[length];
        for (int i = 0; i < length; i++) {
            int count = i+k>nums.length-1? i+k-length:i+k;
            while(count>nums.length-1){
                 count = count-length;
            }
            sum[count] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sum[i];
        }
        System.out.println(JSONObject.toJSON(nums));
    }
}
