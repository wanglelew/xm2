package com.wang.articleservice.feignclient;


import com.wang.articleservice.entity.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 王乐乐 WLL
 * @Classname VideoFeignClient
 * @Describe:
 * @date 2021/2/26 15:51
 */
@FeignClient("video-service") //代表这是一个OpenFeign的客户端,video-service是数据提供方在nacos中注册的微服务名
public interface VideoFeignClient {

    @GetMapping("/getVideo")
    public Video getByArtcileId(@RequestParam("articleId") Long articleId);

}
