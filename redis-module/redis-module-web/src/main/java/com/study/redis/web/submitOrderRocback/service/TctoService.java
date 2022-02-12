package com.study.redis.web.submitOrderRocback.service;

import com.study.redis.web.submitOrderRocback.dto.TcToOrder;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/17 20:23
 */
public interface TctoService {
    public void submitTcOrder(TcToOrder tcToOrder);
}
