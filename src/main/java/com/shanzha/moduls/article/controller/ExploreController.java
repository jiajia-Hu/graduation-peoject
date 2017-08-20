package com.shanzha.moduls.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shanzha.moduls.article.entity.ArticleLikeExample;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.service.ArticleLikeService;
import com.shanzha.moduls.article.service.ArticleService;
import com.shanzha.moduls.topic.entity.Topic;
import com.shanzha.moduls.topic.service.TopicService;

@Controller
@RequestMapping("/explore")
public class ExploreController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	ArticleLikeService articleLikeService;

	@Autowired
	TopicService topicService;
	
	@RequestMapping("/recommendations")
	public String recommendations(Model model) {
		//推荐算法。。。。没写出来。。。

		List<ArticleWithBLOBs> articles = articleService.selectDetail(null);
		ArticleLikeExample example = new ArticleLikeExample();
		for (ArticleWithBLOBs article : articles) {

			example.clear();
			example.createCriteria().andArticleIdEqualTo(article.getId());
			article.setLikeNum(articleLikeService.countByExample(example));
			
		}

		List<ArticleWithBLOBs> article24Hot = articleService.select24Hot(null);

		List<ArticleWithBLOBs> hotCollect = articleService.selectHotCollect(null);
		
		List<Topic> hotTopics = topicService.selectHotTopic(null);

		model.addAttribute("articles", articles);

		model.addAttribute("article24Hot", article24Hot);

		model.addAttribute("hotCollect", hotCollect);

		model.addAttribute("hotTopics", hotTopics);

		return "recommendations";
	}

}
