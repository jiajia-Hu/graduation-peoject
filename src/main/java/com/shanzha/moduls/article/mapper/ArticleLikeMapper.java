package com.shanzha.moduls.article.mapper;

import com.shanzha.moduls.article.entity.ArticleLike;
import com.shanzha.moduls.article.entity.ArticleLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleLikeMapper {
    long countByExample(ArticleLikeExample example);

    int deleteByExample(ArticleLikeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleLike record);

    int insertSelective(ArticleLike record);

    List<ArticleLike> selectByExample(ArticleLikeExample example);

    ArticleLike selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleLike record, @Param("example") ArticleLikeExample example);

    int updateByExample(@Param("record") ArticleLike record, @Param("example") ArticleLikeExample example);

    int updateByPrimaryKeySelective(ArticleLike record);

    int updateByPrimaryKey(ArticleLike record);
}