package com.shanzha.moduls.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.entity.UserExample;
import com.shanzha.moduls.sys.entity.UserExample.Criteria;
import com.shanzha.moduls.sys.mapper.UserMapper;

@Service
public class UserService{

	@Autowired
	private UserMapper userMapper;
	
	public User selectByPrimaryKey(Long id){
		
		return userMapper.selectByPrimaryKey(id);
	}
	public User selectByUsername(String userName){
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<User> users = userMapper.selectByExample(userExample);
		if(users.isEmpty()){
			return null;
		}
		return users.get(0);
	}
	
	public List<User> selectByExample(UserExample example){
		return userMapper.selectByExample(example);
		
	}
	
	public int insert(User user){
		user.setEnabled(1);
		return userMapper.insert(user);
	}
	
	public int deleteByExample(UserExample example){
		
		return userMapper.deleteByExample(example);
	}
	
	public int updateByExampleSelective(User record,UserExample example){
		
		return userMapper.updateByExampleSelective(record, example);
	}
	
	public int updateByPrimaryKey(User record){
		
		return userMapper.updateByPrimaryKey(record);
	}
	
	public int updateByPrimaryKeySelective(User record){
		
		return userMapper.updateByPrimaryKeySelective(record);
	}
	
}
