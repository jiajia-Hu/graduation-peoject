package com.shanzha.moduls.article.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.article.entity.ArticleLike;
import com.shanzha.moduls.article.entity.ArticleLikeExample;
import com.shanzha.moduls.article.mapper.ArticleLikeMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class ArticleLikeService {

	@Autowired
	ArticleLikeMapper articleLikeMapper;
	
	
	public int insert(ArticleLike record){
		record.setLikeDate(new Date());
		record.setUserId(UserUtils.getCurrentUserId());
		return articleLikeMapper.insert(record);
	}

	public long countByExample(ArticleLikeExample example){
		return articleLikeMapper.countByExample(example);
	}
	
	public List<ArticleLike> selectByExample(ArticleLikeExample example){
		
		return articleLikeMapper.selectByExample(example);
	}

}
