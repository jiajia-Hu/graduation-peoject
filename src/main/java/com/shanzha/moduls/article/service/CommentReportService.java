package com.shanzha.moduls.article.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.article.entity.CommentReport;
import com.shanzha.moduls.article.mapper.CommentReportMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class CommentReportService {

	@Autowired
	CommentReportMapper commentReportMapper;
	
	
	public int insert(CommentReport record){
		record.setReportDate(new Date());
		record.setUserId(UserUtils.getCurrentUserId());
		return commentReportMapper.insert(record);
	}


}
