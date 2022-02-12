package com.study.empty.ansyThread.rest;

import java.util.concurrent.Callable;

/**
 * @Author：
 * @Description：
 * @Date： 2021/3/4 20:57
 */
public class AnsyThread implements Callable<Integer>{
    int start;
    int end;

    @Override
    public Integer call() throws Exception {
        Thread.sleep(10000);
        return  start+end;
    }

    public AnsyThread(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
