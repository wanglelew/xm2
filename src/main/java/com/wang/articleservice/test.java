package com.wang.articleservice;

import com.wang.articleservice.entity.Video;
import com.wang.articleservice.feignclient.VideoFeignClient;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 王乐乐 WLL
 * @Classname test
 * @Describe:
 * @date 2021/3/4 11:40
 */
@SpringBootTest
public class test {
    @Resource
    private VideoFeignClient videoFeignClient;
    @Test
    public void getArticle() {
        Video video = videoFeignClient.getByArtcileId(1649l);
        System.out.println(video);
    }
}
