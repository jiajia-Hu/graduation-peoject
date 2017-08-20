package com.shanzha.moduls.article.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.article.entity.ArticleCollect;
import com.shanzha.moduls.article.entity.ArticleCollectExample;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.mapper.ArticleCollectMapper;
import com.shanzha.moduls.article.mapper.ArticleMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class ArticleCollectService {

	@Autowired
	ArticleCollectMapper articleCollectMapper;

	@Autowired
	ArticleMapper articleMapper;

	public int insert(ArticleCollect record) {
		record.setCollectDate(new Date());
		record.setUserId(UserUtils.getCurrentUserId());
		return articleCollectMapper.insert(record);
	}

	public List<ArticleCollect> selectByExample(ArticleCollectExample example) {

		return articleCollectMapper.selectByExample(example);
	}

	public List<ArticleWithBLOBs> selectMyCollection(Long userId) {

		return articleMapper.selectMyCollection(userId);
	}

}
