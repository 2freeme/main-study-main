package com.study.redis.web.submitOrderRocback.dto;

import lombok.Data;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/11 14:50
 */
@Data
public class RedisBack {
    private String key;
    private String hashkey;
    private Long qty;
}
