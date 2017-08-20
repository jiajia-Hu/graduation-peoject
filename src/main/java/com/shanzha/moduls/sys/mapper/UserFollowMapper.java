package com.shanzha.moduls.sys.mapper;

import com.shanzha.moduls.sys.entity.UserFollow;
import com.shanzha.moduls.sys.entity.UserFollowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFollowMapper {
    long countByExample(UserFollowExample example);

    int deleteByExample(UserFollowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserFollow record);

    int insertSelective(UserFollow record);

    List<UserFollow> selectByExample(UserFollowExample example);

    UserFollow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserFollow record, @Param("example") UserFollowExample example);

    int updateByExample(@Param("record") UserFollow record, @Param("example") UserFollowExample example);

    int updateByPrimaryKeySelective(UserFollow record);

    int updateByPrimaryKey(UserFollow record);
}