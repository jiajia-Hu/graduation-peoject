package com.shanzha.moduls.article.mapper;

import com.shanzha.moduls.article.entity.InviteAnswer;
import com.shanzha.moduls.article.entity.InviteAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InviteAnswerMapper {
    long countByExample(InviteAnswerExample example);

    int deleteByExample(InviteAnswerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InviteAnswer record);

    int insertSelective(InviteAnswer record);

    List<InviteAnswer> selectByExample(InviteAnswerExample example);

    InviteAnswer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InviteAnswer record, @Param("example") InviteAnswerExample example);

    int updateByExample(@Param("record") InviteAnswer record, @Param("example") InviteAnswerExample example);

    int updateByPrimaryKeySelective(InviteAnswer record);

    int updateByPrimaryKey(InviteAnswer record);
}