package com.shanzha.moduls.article.mapper;

import com.shanzha.moduls.article.entity.CommentReport;
import com.shanzha.moduls.article.entity.CommentReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentReportMapper {
    long countByExample(CommentReportExample example);

    int deleteByExample(CommentReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentReport record);

    int insertSelective(CommentReport record);

    List<CommentReport> selectByExample(CommentReportExample example);

    CommentReport selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentReport record, @Param("example") CommentReportExample example);

    int updateByExample(@Param("record") CommentReport record, @Param("example") CommentReportExample example);

    int updateByPrimaryKeySelective(CommentReport record);

    int updateByPrimaryKey(CommentReport record);
}