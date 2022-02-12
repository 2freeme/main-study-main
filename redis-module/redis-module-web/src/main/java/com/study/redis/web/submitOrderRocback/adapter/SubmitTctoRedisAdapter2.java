package com.study.redis.web.submitOrderRocback.adapter;

import com.study.redis.web.submitOrderRocback.holder.RedisLockRoubackHolder;
import com.study.redis.web.submitOrderRocback.dto.RedisBack;
import com.study.redis.web.submitOrderRocback.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;

import java.util.List;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/11 14:58
 */
@Service
public class SubmitTctoRedisAdapter2 extends TransactionSynchronizationAdapter {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisService  redisService;

    public void afterCompletion(int status) {
        if (status != TransactionSynchronization.STATUS_COMMITTED) {
            List<RedisBack> list = RedisLockRoubackHolder.getList();
            list.forEach(redisBack -> {

                        redisTemplate.opsForHash().increment(redisBack.getKey(), redisBack.getHashkey(), redisBack.getQty() * -1);
                    }

            );

        }
    }

}
