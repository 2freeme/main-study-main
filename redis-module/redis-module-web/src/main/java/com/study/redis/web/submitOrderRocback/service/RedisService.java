package com.study.redis.web.submitOrderRocback.service;

import com.study.redis.web.submitOrderRocback.dto.TcToOrder;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/11 14:33
 */
public interface RedisService {

    Long getFromRedis(TcToOrder tcToOrder);

    void setRedis(TcToOrder tcToOrder);

    void increment(TcToOrder tcToOrder);

}
