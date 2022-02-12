package com.study.redis.web.submitOrderRocback.service.impl;

import com.study.redis.web.submitOrderRocback.adapter.SubmitTctoRedisAdapter2;
import com.study.redis.web.submitOrderRocback.dao.TctoOrderDao;
import com.study.redis.web.submitOrderRocback.dto.RedisBack;
import com.study.redis.web.submitOrderRocback.dto.TcToOrder;
import com.study.redis.web.submitOrderRocback.holder.RedisLockRoubackHolder;
import com.study.redis.web.submitOrderRocback.service.RedisService;
import com.study.redis.web.submitOrderRocback.service.TctoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/11 14:35
 */
@Slf4j
@Service
public class TctoServiceImpl implements TctoService {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisService redisService;

    @Resource
    TctoOrderDao tctoOrderDao;

    @Transactional //已测试事务生效
    public void submitTcOrder(TcToOrder tcToOrder) {
        //1、校验

        //2、增加锁定库存
        redisService.increment(tcToOrder);

        //3、锁定的数据放到线程变量中
        RedisLockRoubackHolder.putList(tcToOrder);

        //4、监听事务
        TransactionSynchronizationManager.registerSynchronization(new SubmitTctoRedisAdapter());

        //3、保存数据库
        tctoOrderDao.insert(tcToOrder);

        if (tcToOrder.getQty() % 2 == 0) throw new RuntimeException();//模拟报错

        redisService.getFromRedis(tcToOrder);

    }

    public class SubmitTctoRedisAdapter extends TransactionSynchronizationAdapter {
        public void afterCompletion(int status) {
            if (status != TransactionSynchronization.STATUS_COMMITTED) {
                List<RedisBack> list = RedisLockRoubackHolder.getList();
                for (RedisBack redisBack : list) {
                    //单独部署的类注入不进去会报null
                    redisTemplate.opsForHash().increment(redisBack.getKey(), redisBack.getHashkey(), redisBack.getQty() * -1);
                }
            }
        }
    }

}
