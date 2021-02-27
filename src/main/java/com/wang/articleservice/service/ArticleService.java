package com.wang.articleservice.service;

import com.wang.articleservice.entity.Article;
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
    public List<Article> list(){
        return articleMapper.selectAll();
    }
}
