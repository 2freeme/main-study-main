package com.study.redis.web.submitOrderRocback.rest;

import com.study.redis.web.submitOrderRocback.dto.TcToOrder;
import com.study.redis.web.submitOrderRocback.service.RedisService;
import com.study.redis.web.submitOrderRocback.service.TctoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/11 14:32
 */
@RestController
@RequestMapping("/tcto")
public class TcToController {
    @Autowired
    TctoService tctoService;

    @Autowired
    RedisService redisService;

    private long a = 1;

    @GetMapping("/submitTctoOrder")
    public String submitTctoOrder(TcToOrder tcToOrder) {
        tcToOrder.setId(a);
        tcToOrder.setUserName("user" + a);
        a++;
        tctoService.submitTcOrder(tcToOrder);
        return "success";
    }
}
