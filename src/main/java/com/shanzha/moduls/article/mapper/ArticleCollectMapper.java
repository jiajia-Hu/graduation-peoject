package com.shanzha.moduls.article.mapper;

import com.shanzha.moduls.article.entity.ArticleCollect;
import com.shanzha.moduls.article.entity.ArticleCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCollectMapper {
    long countByExample(ArticleCollectExample example);

    int deleteByExample(ArticleCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleCollect record);

    int insertSelective(ArticleCollect record);

    List<ArticleCollect> selectByExample(ArticleCollectExample example);

    ArticleCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleCollect record, @Param("example") ArticleCollectExample example);

    int updateByExample(@Param("record") ArticleCollect record, @Param("example") ArticleCollectExample example);

    int updateByPrimaryKeySelective(ArticleCollect record);

    int updateByPrimaryKey(ArticleCollect record);
}