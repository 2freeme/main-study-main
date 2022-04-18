package com.study.empty.leetCode.middle;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2022/4/3 14:35
 */
public class LetCode11 {


    @Test
    public void test2() {
        int[] nums2 = new int[]{1,8,6,2,5,4,8,3,7};

        System.out.println(JSONObject.toJSONString(maxArea(nums2)));
        int a = 1;
        System.out.println(a++);
        System.out.println(a++);

    }

    public int maxArea(int[] height) {
        //双指针的方法来做。
        int length = height.length;
        int l = 0, r = length-1, sum = 0;
        while (l < r) {

            int htg;
            //这里面最重要的思想就是知道当两个指针的小数（无论大数如何移动 都会以最小值算，而且因为移动距离变近所得更小）
            if (height[l] < height[r]) {
                htg = height[l++];
            } else {
                htg = height[r--];
            }
            sum = Math.max(sum, htg * (r - l +1));// 因为前面见掉了
        }
        return sum;
    }


    //自己通过双循环的方式暴力的解决了，但是容易超时，最后还是需要双指针的方法来做。
    public int maxArea2(int[] height) {
        int length = height.length;
        int left = 0, right = 0, sum = 0;
        for (int i = 0; i < length; i++) {
            if (left > height[i]) {
                continue;
            }
            for (int j = length - 1; j > i; j--) {
                if (right > height[j]) {
                    continue;
                }
                sum = Math.max((j - i) * Math.min(height[i], height[j]), sum);
            }
        }
        return sum;
    }

}
