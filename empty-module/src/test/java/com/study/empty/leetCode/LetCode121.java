package com.study.empty.leetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author： Dingpengfei
 * @Description：给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @Date： 2022/4/1 16:29
 */
public class LetCode121 {
    @Test
    public void test2() {
        Stack<String> strings = new Stack<>();
        String i = "){";
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

    /**
     * 这里的解法其实也是最长字符集类似的解法
     */
    public int maxProfit(int[] prices) {
//        动态规划一直留下最小的即可
        int mix = prices[0];
        int sum =0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<=mix){
                mix = prices[i];
            }else{
                sum = Math.max(prices[i]-mix,sum);
            }
        }
        return sum;
    }
}
