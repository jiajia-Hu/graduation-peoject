package com.shanzha.moduls.article.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.article.entity.ArticleExample;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.mapper.ArticleMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class ArticleService {

	@Autowired
	ArticleMapper articleMapper;

	public int insert(ArticleWithBLOBs record) {

		record.setAuthor(UserUtils.getCurrentUserId());

		record.setPublishDate(new Date());

		return articleMapper.insert(record);
	}

	public ArticleWithBLOBs selectByPrimaryKey(Long id) {
		return articleMapper.selectByPrimaryKey(id);

	}

	public List<ArticleWithBLOBs> selectByExampleWithBLOBs(ArticleExample example) {

		return articleMapper.selectByExampleWithBLOBs(example);

	}

	public List<ArticleWithBLOBs> selectDetail(ArticleExample example) {

		return articleMapper.selectDetail(example);

	}
	

	public List<ArticleWithBLOBs> select24Hot(ArticleExample example) {

		return articleMapper.select24Hot(example);

	}

	public List<ArticleWithBLOBs> selectHotCollect(ArticleExample example) {
		
		return articleMapper.selectHotCollect(example);
		
	}
	
	
	public List<ArticleWithBLOBs> selectRelacted(ArticleExample example) {
		
		return articleMapper.selectRelacted(example);
		
	}
	
	public int deleteByPrimaryKey(Long id){
		
		return articleMapper.deleteByPrimaryKey(id);
	}
	
	

}
