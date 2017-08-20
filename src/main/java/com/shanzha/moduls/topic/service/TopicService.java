package com.shanzha.moduls.topic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.topic.entity.Topic;
import com.shanzha.moduls.topic.entity.TopicExample;
import com.shanzha.moduls.topic.mapper.TopicMapper;

@Service
public class TopicService {

	@Autowired
	TopicMapper topicMapper;

	public List<Topic> selectByExample(TopicExample example) {

		return topicMapper.selectByExample(example);
	}
	
	public Topic selectByPrimaryKey(Long id) {

		return topicMapper.selectByPrimaryKey(id);
	}

	public List<Topic> selectHotTopic(TopicExample example) {

		return topicMapper.selectHotTopic(example);
	}
	
	public List<Topic> selectMyFollow(Long userId) {
		
		return topicMapper.selectMyFollow(userId);
	}

}
