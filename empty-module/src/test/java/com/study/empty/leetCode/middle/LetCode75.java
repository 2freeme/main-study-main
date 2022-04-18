package com.study.empty.leetCode.middle;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date： 2022/4/14 16:18
 */
public class LetCode75 {


    @Test
    public void test2() {
        int[] nums2 = new int[]{0,2,2,1,1};
        sortColors(nums2);
        System.out.println(JSONObject.toJSONString(null));
        int a = 1;
        System.out.println(a++);
        System.out.println(a++);

    }

    public void sortColors(int[] nums) {
        //冒泡排序
        int length = nums.length;

        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if (nums[j] >nums[j+1]){
                    swap(nums, j ,j+1);
                }
            }
        }
        System.out.println(JSONObject.toJSONString((nums)));
    }
    public void swap (int[]a ,int b, int c){
        int temp = a[b];
        a[b]=a[c];
        a[c] =temp;
//        System.out.println(JSONObject.toJSON(a));
    }
}
