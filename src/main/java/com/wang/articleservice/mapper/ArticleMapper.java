package com.wang.articleservice.mapper;

import com.wang.articleservice.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王乐乐 WLL
 * @Classname ArticleMapper
 * @Describe:
 * @date 2021/2/26 14:57
 */
@Mapper
public interface ArticleMapper {
    @Select("select * from article order by create_time desc")
    public List<Article> selectAll();
}
