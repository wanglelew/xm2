package com.wang.articleservice.service;

import com.wang.articleservice.entity.Article;
import com.wang.articleservice.entity.Video;
import com.wang.articleservice.feignclient.VideoFeignClient;
import com.wang.articleservice.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王乐乐 WLL
 * @Classname ArticleService
 * @Describe:
 * @date 2021/2/26 15:02
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private VideoFeignClient videoFeignClient;
    public List<Article> list(){
        List<Article> list = articleMapper.selectAll();
        for (Article article : list) {
            Video video=videoFeignClient.getByArtcileId(article.getArticleId());
            article.setVideo(video);
        }
        return list;
    }
}
