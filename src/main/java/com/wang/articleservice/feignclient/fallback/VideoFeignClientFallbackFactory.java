package com.wang.articleservice.feignclient.fallback;

import com.wang.articleservice.dto.ResultVo;
import com.wang.articleservice.entity.Video;
import com.wang.articleservice.feignclient.VideoFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * openfeign fallback factory 书写规则
 * 1.实现FallbackFactory接口,并且泛型为所对应的FeignClient
 * 2.增加@Component注解,让spring对其加载并且实例化,并进行ioc容器管理
 * 3.在create()方法中实现FeignClient,说明熔断/限流时的操作
 */
@Component
public class VideoFeignClientFallbackFactory implements FallbackFactory<VideoFeignClient> {
    @Override
    public VideoFeignClient create(Throwable throwable) {
        return new VideoFeignClient() {
            @Override
            public ResultVo<Video> getByArtcileId(Long articleId) {
                System.out.println("触发异常:"+throwable.getClass().getSimpleName());
                throwable.printStackTrace();
                Video video=new Video();
                video.setVideoId(-1l);
                video.setSn("UNKNOWN");
                return new ResultVo<>(throwable.getClass().getSimpleName(),"熔断或降级",video);
            }
        };
    }
}
