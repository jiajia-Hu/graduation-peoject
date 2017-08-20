package com.shanzha.moduls.article.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shanzha.moduls.article.entity.Article;
import com.shanzha.moduls.article.entity.ArticleExample;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;

public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);
    
    List<ArticleWithBLOBs> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    ArticleWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);
    
    List<ArticleWithBLOBs> selectDetail(ArticleExample example);
    
    List<ArticleWithBLOBs> select24Hot(ArticleExample example);
    
    List<ArticleWithBLOBs> selectHotCollect(ArticleExample example);

    List<ArticleWithBLOBs> selectRelacted(ArticleExample example);
    
    List<ArticleWithBLOBs> selectMyCollection( @Param("userId")Long userId);
    
}