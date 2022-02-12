package com.study.redis.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@MapperScan("com.study.redis.web.submitOrderRocback.dao")
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
//这里启动的时候 Caused by: java.lang.IllegalArgumentException: Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
//@SpringBootApplication()
public class RedisModuleWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisModuleWebApplication.class, args);
    }
}
