package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @Date： 2022/3/12 16:19
 */
public class LetCode283 {
    @Test
    public void test2() {
        int[] nums = new int[]{0, 0, 1};
        moveZeroes2(nums);
        int a= 0;
        System.out.println(a++);
        System.out.println(a);
        System.out.println(JSONObject.toJSON(nums));
    }

    //自己写的  但是边界问题没处理好
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int j = i;
                while ( j < length - 1) {
                    swap(nums, j, j + 1);//这里的问题就是当连续的几个 0 出现的时候会导致数据的不完整
                    j++;
                }
            }
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    //利用快慢指针的问题，快的进行判断 慢的进行赋值，
    public void moveZeroes2(int[] nums) {

        int length = nums.length;
        int j = 0; //从0开始进行的记录
        for (int i = 0; i < length; i++) {
            if (nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i <length ; i++) {
            nums[i]=0;
        }

    }
}
