package com.shanzha.moduls.sys.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.sys.entity.UserFollow;
import com.shanzha.moduls.sys.entity.UserFollowExample;
import com.shanzha.moduls.sys.mapper.UserFollowMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class UserFollowService {
	@Autowired
	UserFollowMapper userFollowMapper;

	public List<UserFollow> selectByExample(UserFollowExample example) {
		return userFollowMapper.selectByExample(example);

	}
	
	public int insert(UserFollow record) {
		record.setFollowDate(new Date());
		record.setUserId(UserUtils.getCurrentUserId());
		return userFollowMapper.insert(record);
	}

}
