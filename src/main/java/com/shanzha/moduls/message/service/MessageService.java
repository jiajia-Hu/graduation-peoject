package com.shanzha.moduls.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.message.entity.Message;
import com.shanzha.moduls.message.entity.MessageExample;
import com.shanzha.moduls.message.entity.MessageExtend;
import com.shanzha.moduls.message.mapper.MessageMapper;

@Service
public class MessageService {

	@Autowired
	MessageMapper messageMapper;

	public List<MessageExtend> selectExtend(Message message) {
		return messageMapper.selectExtend(message);
	}

	public int updateByPrimaryKeySelective(Message record) {

		return messageMapper.updateByPrimaryKeySelective(record);
	}
	
	public int deleteByPrimaryKey(Long id) {

		return messageMapper.deleteByPrimaryKey(id);
	}
	
	
	public int insert(Message record) {

		return messageMapper.insert(record);
	}

	public Message selectByPrimaryKey(Long id) {

		return messageMapper.selectByPrimaryKey(id);
	}

	public List<Message> selectByExample(MessageExample example) {

		return messageMapper.selectByExample(example);
	}

	public int updateByExampleSelective(Message record, MessageExample example) {

		return messageMapper.updateByExampleSelective(record, example);
	}

}
