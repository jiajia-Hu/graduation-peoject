package com.shanzha.moduls.topic.mapper;

import com.shanzha.moduls.topic.entity.TopicFollow;
import com.shanzha.moduls.topic.entity.TopicFollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicFollowMapper {
    long countByExample(TopicFollowExample example);

    int deleteByExample(TopicFollowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TopicFollow record);

    int insertSelective(TopicFollow record);

    List<TopicFollow> selectByExample(TopicFollowExample example);

    TopicFollow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TopicFollow record, @Param("example") TopicFollowExample example);

    int updateByExample(@Param("record") TopicFollow record, @Param("example") TopicFollowExample example);

    int updateByPrimaryKeySelective(TopicFollow record);

    int updateByPrimaryKey(TopicFollow record);
}