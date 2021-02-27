package com.wang.articleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients//开启openfeign实现服务间rest通信
public class ArticleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }

}
