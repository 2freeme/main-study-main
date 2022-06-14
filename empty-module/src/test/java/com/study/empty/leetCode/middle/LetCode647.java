package com.study.empty.leetCode.middle;

import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2022/4/20 0:14
 */
public class LetCode647 {
    @Test
    public void test2() {
        int a = 1;
        System.out.println(a++);
        int length = countSubstrings("aba");
        System.out.println(length);


    }

    public int countSubstrings(String s) {

        int length = s.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            //因为中心对称 所以中心要么1  要么2
            for (int j = 0; j <= 1; j++) {
                int l = i, r = i + j;
                while (l>=0&&l <= r && r <=length-1) {
                    if (s.charAt(l--) == s.charAt(r++)) {
                        sum++;
                    }else{
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
//class Solution {
//    public:
//    int countSubstrings(string s) {
//        int num = 0;
//        int n = s.size();
//        for(int i=0;i<n;i++)//遍历回文中心点
//        {
//            for(int j=0;j<=1;j++)//j=0,中心是一个点，j=1,中心是两个点
//            {
//                int l = i;
//                int r = i+j;
//                while(l>=0 && r<n && s[l--]==s[r++])num++;
//            }
//        }
//        return num;
//    }
