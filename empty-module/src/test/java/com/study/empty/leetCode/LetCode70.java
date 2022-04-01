package com.study.empty.leetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * @Date： 2022/4/1 13:56
 * 解法中 最最重要的思想就是想明白 n个台阶是 n-1 和n-2的台阶之和（因为只能一步或者2步 所以之前的解法完全够用）
 */
public class LetCode70 {
    @Test
    public void test2() {
        Stack<String> strings = new Stack<>();
        String i = "){";
        int[] nums = {5, 4, -1, -7, 8};
        System.out.println(climbStairs2(43));
    }

    /**
     * 这里的递归的问题有所不足的原因是因为进行了重复计算
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 2) + climbStairs(n - 1);
    }


    /**
     * 核心思想就是在循环的时候一直将 n-1 和 n-2记录下来 后面直接相加即可
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                nums[1] = 1;
            } else if (i == 2) {
                nums[2] = 2;
            } else {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
        }
        return nums[n - 1] + nums[n - 2];
    }
}
