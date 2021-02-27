package com.wang.articleservice.controller;

import com.wang.articleservice.entity.Article;
import com.wang.articleservice.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 王乐乐 WLL
 * @Classname ArticleController
 * @Describe:
 * @date 2021/2/26 15:05
 */
@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @GetMapping("/getArticle")
    public List<Article> list(){
        return articleService.list();
    }
}
