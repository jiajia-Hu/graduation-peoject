package com.shanzha.moduls.sys.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.sys.entity.UserFollow;
import com.shanzha.moduls.sys.entity.UserProfile;
import com.shanzha.moduls.sys.entity.UserProfileExample;
import com.shanzha.moduls.sys.mapper.UserFollowMapper;
import com.shanzha.moduls.sys.mapper.UserProfileMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileMapper userProfileMapper;
	@Autowired
	private UserFollowMapper userFollowMapper;

	public UserProfile selectByPrimaryKey(Long id) {

		return userProfileMapper.selectByPrimaryKey(id);
	}

	public int insert(UserProfile record) {

		return userProfileMapper.insert(record);
	}

	
	
	public int updateByPrimaryKeySelective(UserProfile record) {
		return userProfileMapper.updateByPrimaryKeySelective(record);

	}

	public List<UserProfile> selectByExample(UserProfileExample example) {
		return userProfileMapper.selectByExample(example);

	}
}
