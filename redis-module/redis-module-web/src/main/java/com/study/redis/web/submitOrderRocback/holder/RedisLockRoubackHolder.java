package com.study.redis.web.submitOrderRocback.holder;

import com.study.redis.web.submitOrderRocback.dto.RedisBack;
import com.study.redis.web.submitOrderRocback.dto.TcToOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/11 14:48
 */
@Data
public class RedisLockRoubackHolder {
    private static ThreadLocal<List<RedisBack>> listThreadLocal = new ThreadLocal<>();
    //这里使用static而不会引起线程安全的问题的原因就是，ThreadLocal对于每一个线程都保持着一个副本，互不影响
    //详见com.study.empty.threadLocal.ThreadLocalDemo

    public static void putList(TcToOrder tcToOrder){
        RedisBack redisBack = new RedisBack();
        redisBack.setKey(tcToOrder.getItemCode());
        redisBack.setHashkey("LOCKCURRENT");
        redisBack.setQty(tcToOrder.getQty());
        List<RedisBack> list = new ArrayList<>();
        list.add(redisBack);
        listThreadLocal.set(list);
    }

    public static void clearList(){
        listThreadLocal.remove();
    }

    public static List<RedisBack> getList(){
        return listThreadLocal.get();
    }


}
