package com.study.empty.leetCode;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author： Dingpengfei
 * @Description：力扣的前十道题
 * @Date： 2022/2/13 14:09
 */
public class LetCode3 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abbaxd"));
    }


    public int lengthOfLongestSubstring(String s) {
        //用窗口滑动的方法来看
        //每次记录最大的不同的值 ，遇到相同的 start往后移一位
        int start = 0; int end =0,max =0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();//用于记录出现的位置然后对应相应的start 记录的是顺序从1开始
        for (int i = 0; end < chars.length; end++) { //窗口滑动 用end作为结束的条件
            Character c = chars[end] ;
            if (map.containsKey(c)){
//                start = start+1;
//                start = map.get(c); //不用这个的原因因为start可能会有倒退的情况
                start = Math.max(start,map.get(c));//这里不用start +1 作为判断的主要原因就是 当出现了重复的字母的时候的跳跃性直接把窗口的起点跳到这次出现的地方
            }
            map.put(c,end+1);
            max = Math.max(max,end-start+1);
        }
        return max;

    }
}
