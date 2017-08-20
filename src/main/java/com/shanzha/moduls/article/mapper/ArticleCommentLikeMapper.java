package com.shanzha.moduls.article.mapper;

import com.shanzha.moduls.article.entity.ArticleCommentLike;
import com.shanzha.moduls.article.entity.ArticleCommentLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCommentLikeMapper {
    long countByExample(ArticleCommentLikeExample example);

    int deleteByExample(ArticleCommentLikeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleCommentLike record);

    int insertSelective(ArticleCommentLike record);

    List<ArticleCommentLike> selectByExample(ArticleCommentLikeExample example);

    ArticleCommentLike selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleCommentLike record, @Param("example") ArticleCommentLikeExample example);

    int updateByExample(@Param("record") ArticleCommentLike record, @Param("example") ArticleCommentLikeExample example);

    int updateByPrimaryKeySelective(ArticleCommentLike record);

    int updateByPrimaryKey(ArticleCommentLike record);
}