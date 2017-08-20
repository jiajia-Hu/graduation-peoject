package com.shanzha.moduls.article.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.article.entity.ArticleCommentLike;
import com.shanzha.moduls.article.entity.ArticleCommentLikeExample;
import com.shanzha.moduls.article.mapper.ArticleCommentLikeMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class ArticleCommentLikeService {

	@Autowired
	ArticleCommentLikeMapper articleCommentLikeMapper;
	
	
	public int insert(ArticleCommentLike record){
		record.setLikeDate(new Date());
		record.setUserId(UserUtils.getCurrentUserId());
		return articleCommentLikeMapper.insert(record);
	}
	
	public long countByExample(ArticleCommentLikeExample example){
		
		return articleCommentLikeMapper.countByExample(example);
	}


}
