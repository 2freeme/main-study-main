package com.study.empty.ansyThread.service.impl;

import com.study.empty.ansyThread.service.AnsyService;
import org.springframework.stereotype.Service;

/**
 * @Author：
 * @Description：
 * @Date： 2021/3/4 19:36
 */
@Service
public class AnsyServiceImpl implements AnsyService{
    @Override
    public Integer ansyCeshi() {
        try {
            Thread.sleep(11l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
