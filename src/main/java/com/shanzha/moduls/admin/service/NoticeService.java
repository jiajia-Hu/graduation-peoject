package com.shanzha.moduls.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.admin.entity.Notice;
import com.shanzha.moduls.admin.entity.NoticeExample;
import com.shanzha.moduls.admin.mapper.NoticeMapper;

@Service
public class NoticeService {

	@Autowired
	NoticeMapper noticeMapper;

	public int insert(Notice notice) {

		return noticeMapper.insert(notice);
	}

	public int deleteByPrimaryKey(Long id) {
		
		return noticeMapper.deleteByPrimaryKey(id);
	}
	
	public List<Notice> selectByExample(NoticeExample example){
		
		
		return noticeMapper.selectByExampleWithBLOBs(example);
	}
	
	public int updateByPrimaryKeySelective(Notice record){
		
		return noticeMapper.updateByPrimaryKeySelective(record);
	}
	
	
}
