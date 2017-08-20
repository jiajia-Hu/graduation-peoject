package com.shanzha.moduls.article.mapper;

import com.shanzha.moduls.article.entity.ArticleReport;
import com.shanzha.moduls.article.entity.ArticleReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleReportMapper {
    long countByExample(ArticleReportExample example);

    int deleteByExample(ArticleReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleReport record);

    int insertSelective(ArticleReport record);

    List<ArticleReport> selectByExample(ArticleReportExample example);

    ArticleReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleReport record, @Param("example") ArticleReportExample example);

    int updateByExample(@Param("record") ArticleReport record, @Param("example") ArticleReportExample example);

    int updateByPrimaryKeySelective(ArticleReport record);

    int updateByPrimaryKey(ArticleReport record);
}