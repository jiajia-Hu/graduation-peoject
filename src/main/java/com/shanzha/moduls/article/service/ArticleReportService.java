package com.shanzha.moduls.article.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.article.entity.ArticleReport;
import com.shanzha.moduls.article.entity.ArticleReportExample;
import com.shanzha.moduls.article.mapper.ArticleReportMapper;
import com.shanzha.moduls.sys.utils.UserUtils;

@Service
public class ArticleReportService {

	@Autowired
	ArticleReportMapper articleReportMapper;

	public int insert(ArticleReport record) {
		record.setReportDate(new Date());
		record.setUserId(UserUtils.getCurrentUserId());
		return articleReportMapper.insert(record);
	}

	public List<ArticleReport> selectByExample(ArticleReportExample example) {

		return articleReportMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Long id) {

		return articleReportMapper.deleteByPrimaryKey(id);
	}

}
