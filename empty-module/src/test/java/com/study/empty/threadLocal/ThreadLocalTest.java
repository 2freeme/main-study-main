package com.study.empty.threadLocal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/19 14:04
 */
@RunWith(SpringRunner.class)
public class ThreadLocalTest {
    ThreadLocal<String> test
            = new ThreadLocal<>();

    @Test
    public void test1(){
        Thread threadTest = new Thread(new ThreadTest());
        threadTest.start();
        System.out.println("线程结束"+test.get());
    }

    class ThreadTest implements Runnable{
        @Override
        public void run() {
            test.set("aaaa");
            java.lang.Thread.currentThread().setName("aaa");
            System.out.println("线程中"+test.get());

        }
    }

    class ThreadLocalDto extends ThreadLocal{

        public void ceshi(){

        }
    }
}
