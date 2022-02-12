package com.study.redis.web.submitOrderRocback.rest;

import com.study.redis.web.submitOrderRocback.dto.TcToOrder;
import com.study.redis.web.submitOrderRocback.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/17 21:40
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    RedisService redisService;

    @GetMapping("set") //http://localhost:8099/redis/set?itemCode=ceshi&qty=4
    public String setRedis(TcToOrder tcToOrder) {
        redisService.setRedis(tcToOrder);
        return "success";
    }

    @GetMapping("get") //http://localhost:8099/redis/get?itemCode=ceshi
    public String getRedis(TcToOrder tcToOrder) {
        Long fromRedis = redisService.getFromRedis(tcToOrder);
        return fromRedis.toString();
    }

}
