package com.study.empty.voliate;

import java.util.concurrent.CountDownLatch;

/**
 * @Author：
 * @Description：测试并发场景下的voliate的访问问题
 * @Date： 2021/2/9 12:48
 */
public class VolatileTest {
    static volatile int a = 0 ;
    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            TestThread testThread = new TestThread();

        }

    }

    static class TestThread implements Runnable{
        @Override
        public void run() {
            a++;
        }
    }
}
