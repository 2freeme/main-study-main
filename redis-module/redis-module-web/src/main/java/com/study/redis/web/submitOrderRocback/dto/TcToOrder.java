package com.study.redis.web.submitOrderRocback.dto;

import lombok.Data;

/**
 * @Author：
 * @Description：
 * @Date： 2021/2/11 14:43
 */
@Data
public class TcToOrder {
    private Long id;
    private String userName;
    private Long qty;
    private String itemCode;
}
