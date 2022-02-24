package com.study.empty.myTest;

import com.alibaba.fastjson.JSONObject;
import lombok.ToString;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：选择排序
 * @Date： 2022/2/24 21:47
 */
public class SelectTest {


    @Test
    public void test(){
        int[] a = {5, 4, 11, 2, 1, 54, 8,12,45,4564};

        for (int j = 0; j < a.length -1; j++) {//-1 是为了少循环一次
            //先找到最小值
            int mix =j;
            for (int i = j+1; i < a.length; i++) {
                if (a[mix]>a[i]){
                    mix=i;
                }
            }
            swap(a,j,mix);
        }
        System.out.println(JSONObject.toJSON(a));


    }

    public void swap (int[]a ,int b, int c){
        int temp = a[b];
        a[b]=a[c];
        a[c] =temp;
        System.out.println(JSONObject.toJSON(a));
    }
}
