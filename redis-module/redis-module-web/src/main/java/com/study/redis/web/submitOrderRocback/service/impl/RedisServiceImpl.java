package com.study.redis.web.submitOrderRocback.service.impl;

import com.study.redis.web.submitOrderRocback.dto.TcToOrder;
import com.study.redis.web.submitOrderRocback.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/11 14:33
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Long getFromRedis(TcToOrder tcToOrder) {
        Object a = redisTemplate.opsForHash().get(tcToOrder.getItemCode(), "LOCKCURRENT");
        log.info("获取库存===商品:{} ==数量:{}", tcToOrder.getItemCode(), a.toString());
        Long fromRedis = Long.valueOf(a.toString());
        return fromRedis;
    }

    public void setRedis(TcToOrder tcToOrder) {
        redisTemplate.opsForHash().put(tcToOrder.getItemCode(), "LOCKCURRENT", tcToOrder.getQty());
        log.info("setRedis ====success");
    }

    public void increment(TcToOrder tcToOrder) {
        Long lockcurrent = redisTemplate.opsForHash().increment(tcToOrder.getItemCode(), "LOCKCURRENT", tcToOrder.getQty());
        log.info("增长后的值：{}", lockcurrent);
    }
}
