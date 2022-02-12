package com.bill.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author： Dingpengfei
 * @Description：
 * @Date： 2021/8/18 23:17
 */
@MapperScan("com.bill.web.dao")
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class BillWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillWebApplication.class, args);
    }

}
