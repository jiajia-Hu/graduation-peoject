package com.shanzha.moduls.topic.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.sys.utils.UserUtils;
import com.shanzha.moduls.topic.entity.TopicFollow;
import com.shanzha.moduls.topic.entity.TopicFollowExample;
import com.shanzha.moduls.topic.mapper.TopicFollowMapper;

@Service
public class TopicFollowService {

	
	@Autowired
	TopicFollowMapper topicFollowMapper;
	
	 public int insert(TopicFollow record){
		 record.setFollowDate(new Date());
		 record.setUserId(UserUtils.getCurrentUserId());
		 
		 return topicFollowMapper.insert(record);
	 }
	 
	 
	 public int deleteByPrimaryKey(Long id ){
		 return topicFollowMapper.deleteByPrimaryKey(id);
	 }
	 
	 public int deleteByExample(TopicFollowExample example ){
		 return topicFollowMapper.deleteByExample(example);
	 }
	 
	 public List<TopicFollow> selectByExample(TopicFollowExample example){
		 
		 return topicFollowMapper.selectByExample(example);
	 }

	 
}
