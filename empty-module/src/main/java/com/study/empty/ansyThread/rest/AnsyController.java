package com.study.empty.ansyThread.rest;

import com.study.empty.ansyThread.service.AnsyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author：
 * @Description：用作异步线程的使用
 * @Date： 2021/3/4 19:33
 */
@RestController
@RequestMapping("/ansy")
public class AnsyController {

    @Autowired
    AnsyService ansyService;

    @GetMapping("ansyCeshi")
    public String ansyCeshi(Integer count) throws InterruptedException, ExecutionException {
        List<Callable<Integer>> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new AnsyThread(i, i + 1));
        }

        //定义固定长度的线程池  防止线程过多，这个数量一般跟自己电脑的CPU核数进行匹配
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //Future用于获取结果
        List<Future<Integer>> futures = executorService.invokeAll(list);

        Integer a=0;
        for (Future<Integer> future : futures) {
            Integer integer = future.get();
            a+=integer;
        }
        executorService.shutdown();
        return a.toString();
    }


    @GetMapping("ansyCeshi2")
    public Long ansyCeshi2(Integer count) throws Exception {

        long l = System.currentTimeMillis();
        //定义固定长度的线程池  防止线程过多，这个数量一般跟自己电脑的CPU核数进行匹配
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //Future用于获取结果
        Future<Integer> submit = executorService.submit(new AnsyThread(count, count + 1));
        if (count / 2 == 0) {
            Integer integer = submit.get();  //阻塞
            System.out.println("1111111111" + integer);

        } else {
            System.out.println("@2222222");
        }

        return  (System.currentTimeMillis()-l);
    }
}
