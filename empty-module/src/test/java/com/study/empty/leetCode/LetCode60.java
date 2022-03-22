package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * @Date： 2022/3/8 23:41
 */
public class LetCode60 {

    @Test
    public void test2() {
        //因为只能嘉义  所以要么是500000 要么是原来的长度
        int[] ints = getInts();
        System.out.println(JSONObject.toJSON(ints));

    }

    private int[] getInts() {
        int[] digits = {9};
        for (int i = digits.length-1; i>=0; i--) {
            digits[i]++;
            digits[i]= digits[i]%10;
            if (digits[i]!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }


    //解法有问题的原因是因为转化数组的越界的问题
    @Test
    public void test() {
        int[] nums = {6,5,4,3,2,1,0};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i] * pow(10, nums.length - i - 1);
        }
        sum += 1;

        int count = 0;
        int sum2 = sum;
        while (sum > 0) {
            sum = sum / 10;
            count += 1;
        }
        System.out.println(count);

        int[] aa = new int[count];

        int index = 0;
        int yushu;
        while (sum2 > 0) {
            yushu = sum2 % 10;
            sum2 = sum2 / 10;
            index++;
            aa[count - index] = yushu;
        }


        System.out.println(JSONObject.toJSON(aa));
    }

    private int pow(int a, int b) {
        int sum = 1;
        for (int i = 0; i < b; i++) {
            sum = sum * a;
        }
        return sum;
    }
}
