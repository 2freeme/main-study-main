package com.study.empty.myTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：计数排序的思想就是新建个数组下标 然后将值放进去
 * @Date： 2022/3/8 23:10
 */
public class JishuTest {


    @Test
    public void test(){
        int[] a = {0,1,2,1,2,1,5,4,3,7,6,7,6,5,1,2,0,3};

        int[] b = new int[10];
        for (int i = 0; i < a.length; i++) {
            int count = a[i];
            b[count]++ ;
        }

        System.out.println(JSONObject.toJSON(b));
        int[] c = new int[a.length];
        int sum =0;
        for (int i = 0; i < b.length; i++) {

            for (int j = 0; j < b[i]; j++) {
                c[sum] = i;
                sum++;
            }
        }
        System.out.println(JSONObject.toJSON(c));

    }

}
