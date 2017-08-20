package com.shanzha.moduls.article.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.article.entity.InviteAnswer;
import com.shanzha.moduls.article.entity.InviteAnswerExample;
import com.shanzha.moduls.article.mapper.InviteAnswerMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class InviteAnswerService {

	
	
	@Autowired
	InviteAnswerMapper inviteAnswerMapper;
	

    public int insert(InviteAnswer record){
    	record.setInviteDate(new Date());
    	record.setInviterId(UserUtils.getCurrentUserId());
    	
    	return inviteAnswerMapper.insert(record);
    }
    
    public List<InviteAnswer> selectByExample(InviteAnswerExample example){
    	
    	return inviteAnswerMapper.selectByExample(example);
    }
	
	
}
