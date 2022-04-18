package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： Dingpengfei
 * @Description：找到所有数组中消失的数字 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * @Date： 2022/4/3 0:04
 */
public class LetCode448 {
    @Test
    public void test2() {
        int[] nums2 = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(JSONObject.toJSONString(findDisappearedNumbers2(nums2)));

    }

    /**
     * 这种方法新增了一个数组 增加了空间的复杂度
     * 接下来就想办法剪掉新增加的数组
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        Integer[] nums2 = new Integer[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            nums2[j] = j;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] == null) {
                list.add(i);
            }
        }
        return list;
    }


    public List<Integer> findDisappearedNumbers2(int[] nums) {

        //为了去掉新增的数组，就要想办法用之前的数组.怎么利用之前的数据就是利用加上长度再取模

        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;

    }
}
