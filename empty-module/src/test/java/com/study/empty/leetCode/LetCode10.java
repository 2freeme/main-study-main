package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author： Dingpengfei
 * @Description：力扣的前十道题
 * @Date： 2022/2/13 14:09
 */
public class LetCode10 {

    @Test
    public void test(){
        int[] nums ={2,7,11,15};
        System.out.println(JSONObject.toJSON(twoSum(nums, 9)));
        System.out.println(JSONObject.toJSON(twoSum2(nums, 9)));
    }
    /**
     * 力扣 1. 两数之和 解法1使用暴力相加对比
     */

    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j <size ; j++) {
                if (nums[i]+ nums[j] ==target){
                    int[] num2 ={i,j};
                    return num2;
                }
            }
        }
        return null;
    }

    /**
     * 解法2使用减法
     * 标签：哈希映射
     这道题本身如果通过暴力遍历的话也是很容易解决的，时间复杂度在 O(n2)O(n2)
     由于哈希查找的时间复杂度为 O(1)O(1)，所以可以利用哈希容器 map 降低时间复杂度
     遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
     如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
     如果最终都没有结果则抛出异常
     时间复杂度：$$

     作者：guanpengchn
     链接：https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> objectObjectHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (objectObjectHashMap.containsKey(target-nums[i])){
                return new int[] {i , objectObjectHashMap.get(target-nums[i])};
            }
            objectObjectHashMap.put(nums[i] ,i);
        }
        return null;
    }
}
