package com.study.empty.leetCode;

import java.time.LocalTime;

public class Test1 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime localTime = now.minusMinutes(30);
        System.out.println(localTime);


    }
}
