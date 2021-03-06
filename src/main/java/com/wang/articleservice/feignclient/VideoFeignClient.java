package com.wang.articleservice.feignclient;


import com.wang.articleservice.dto.ResultVo;
import com.wang.articleservice.entity.Video;
import com.wang.articleservice.feignclient.fallback.VideoFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 王乐乐 WLL
 * @Classname VideoFeignClient
 * @Describe:
 * @date 2021/2/26 15:51
 */
@FeignClient(value = "video-service",fallbackFactory = VideoFeignClientFallbackFactory.class) //代表这是一个OpenFeign的客户端,video-service是数据提供方在nacos中注册的微服务名(必须严格按照大小写)
public interface VideoFeignClient {

    @GetMapping("/getVideo")  // 返回 video-service(调用的服务名,在nacos中的服务名,) 中的 getVideo 地址,@RequestParam传入对应地址的参数articleId=xxx
    public ResultVo<Video> getByArtcileId(@RequestParam("articleId") Long articleId);

}
