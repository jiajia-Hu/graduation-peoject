package com.shanzha.moduls.sys.mapper;

import com.shanzha.moduls.sys.entity.UserProfile;
import com.shanzha.moduls.sys.entity.UserProfileExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserProfileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    long countByExample(UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int deleteByExample(UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int insert(UserProfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int insertSelective(UserProfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    List<UserProfile> selectByExampleWithBLOBs(UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    List<UserProfile> selectByExample(UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    UserProfile selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserProfile record, @Param("example") UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") UserProfile record, @Param("example") UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int updateByExample(@Param("record") UserProfile record, @Param("example") UserProfileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int updateByPrimaryKeySelective(UserProfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(UserProfile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_profile
     *
     * @mbg.generated Tue Dec 20 16:56:46 CST 2016
     */
    int updateByPrimaryKey(UserProfile record);
}