package com.study.empty.myTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：冒泡算法  每次两两交换 把最大值交换到最后
 * @Date： 2022/2/24 22:45
 */
public class MaopaoTest {

    @Test
    public void test() {
        int[] a = {5, 4, 11, 2, 1, 54, 8,12,45,4564};
        for (int j = 0; j < a.length ; j++) {//是为了少循环一次
            //先找到最小值
            //先将点冒到最后  两两互排 然后最终将最大值换到最后
            for (int i = 0 ; i < a.length-j-1; i++) {
                if (a[i] >a[i+1]){
                    swap(a,i,i+1);
                }
            }
        }
        System.out.println(JSONObject.toJSON(a));
    }

    public void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
        System.out.println(JSONObject.toJSON(a));
    }
}
