package com.study.empty.myTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @Author： Dingpengfei
 * @Description：插入排序  从第二位开始将数据放到合适的地方，后面的依次进行移动
 * @Date： 2022/2/24 23:38
 */
public class InsertTest
{

    @Test
    public void test(){
        int[] a = {5, 4, 11, 2, 1, 54, 8,12,45,4564};


        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0; j--) { //这里面从1开始往后 其实保证了前面的顺序都是一定的了
                if (a[j-1]>a[j]){//每次从起始值开始挨个判断他们的差别就可
                    swap(a,j-1,j);
                }
            }
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
