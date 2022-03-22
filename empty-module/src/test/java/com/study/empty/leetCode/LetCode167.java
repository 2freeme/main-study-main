package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2022/3/14 17:14
 */
public class LetCode167 {

    @Test
    public void test2() {
        int[] i = twoSum(new int[]{-7,-3,2,3,11});
        System.out.println(JSONObject.toJSON(i));
    }
    public int[] twoSum(int[] numbers, int target) {

        int length = numbers.length;
        int left =0;
        int right = length-1;
        while(left<right)

    }

}
