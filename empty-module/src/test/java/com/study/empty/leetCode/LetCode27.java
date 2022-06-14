package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date： 2022/4/18 23:53
 */
public class LetCode27 {

    @Test
    public void test2() {
        int[] nums2 = new int[]{0, 2, 2, 1, 1};
    }

    /**
     * 快门指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int l=0;
        for (int r = 0; r < length; r++) {
            if (nums[r] !=val){
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }
}
