package com.shanzha.moduls.article.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.article.entity.ArticleComment;
import com.shanzha.moduls.article.entity.ArticleCommentExample;
import com.shanzha.moduls.article.mapper.ArticleCommentMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class ArticleCommentService {

	@Autowired
	ArticleCommentMapper articleCommentMapper;

	public int insert(ArticleComment record) {

		record.setCommentDate(new Date());
		record.setUserId(UserUtils.getCurrentUserId());

		return articleCommentMapper.insert(record);
	}

	public List<ArticleComment> selectByExampleWithBLOBs(ArticleCommentExample example) {

		return articleCommentMapper.selectByExampleWithBLOBs(example);

	}
	
	
	public  int deleteByPrimaryKey(Long id){
		return articleCommentMapper.deleteByPrimaryKey(id);
	}

}
