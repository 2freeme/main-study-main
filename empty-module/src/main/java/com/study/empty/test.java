package com.study.empty;

import com.study.empty.pojo.Entity;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/9 12:18
 */
public class test {
    private static HashMap<String,String> a = new HashMap<>();

    public static void main(String[] args) {
        String put = a.put("a", "b");

        String a = "a";
        System.out.println(a.hashCode() % 16);
        System.out.println(a.hashCode());

        int h;
        int i = (h = a.hashCode()) ^ (h >>> 16);
        System.out.println(h = a.hashCode());
        System.out.println(h >>> 16);
        System.out.println(i);
        System.out.println("aaaaaa2656aaaaaaaaaaaaaaaa".hashCode());

        Entity entity = new Entity();
        Entity entity2 = new Entity();
        System.out.println(entity.hashCode() == entity2.hashCode());
        entity2.setA(1);
        System.out.println(entity.hashCode() == entity2.hashCode());
        Entity entity3 =entity;
        Entity entity34 =entity3 =entity;
        System.out.println(entity.hashCode() ==entity3.hashCode());
//        1
//        97
//        97
//        0
//        97
//        363282245
//        true
//        false
//        true

//        System.out.println(h = key.hashCode()) ^ (h >>> 16);

    }
}
