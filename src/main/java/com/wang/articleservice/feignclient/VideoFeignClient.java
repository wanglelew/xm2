package com.wang.articleservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 王乐乐 WLL
 * @Classname VideoFeignClient
 * @Describe:
 * @date 2021/2/26 15:51
 */
@FeignClient("video-service") //代表这是一个OpenFeign的客户端,video-service是数据提供方在nacos中注册的微服务名
public interface VideoFeignClient {


}
