package com.study.empty.myTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2022/2/26 21:00
 */
public class GuibingTest {


    @Test
    public void test() {
        int[] a = {5, 4, 11, 2, 1, 54, 8, 12, 45, 4564};

        for (int j = 0; j < a.length - 1; j++) {//-1 是为了少循环一次
            //先找到最小值
            int mix = j;
            for (int i = j + 1; i < a.length; i++) {
                if (a[mix] > a[i]) {
                    mix = i;
                }
            }
            swap(a, j, mix);
        }
        System.out.println(JSONObject.toJSON(a));

        //归并排序是将数据拆分 然后进行排序
        int[] b = {5, 4, 11, 2, 1, 54, 8, 12, 45, 4564};
//        三个指针  一个前一个后 一个新数组，这里是将两个数据进行合并
        int i =0,j =b.length/2 ;
        int bb[] = {b.length};


    }

    public void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
        System.out.println(JSONObject.toJSON(a));
    }
}
