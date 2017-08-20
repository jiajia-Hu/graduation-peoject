package com.shanzha.moduls.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shanzha.moduls.article.entity.ArticleExample;
import com.shanzha.moduls.article.entity.ArticleLikeExample;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.service.ArticleLikeService;
import com.shanzha.moduls.article.service.ArticleService;
import com.shanzha.moduls.message.entity.Message;
import com.shanzha.moduls.message.entity.MessageExample;
import com.shanzha.moduls.message.entity.MessageExample.Criteria;
import com.shanzha.moduls.message.service.MessageService;
import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.utils.UserUtils;
import com.shanzha.moduls.topic.entity.Topic;
import com.shanzha.moduls.topic.service.TopicService;

@Controller
public class IndexController {

	@Autowired
	ArticleService articleService;
	
	@Autowired
	ArticleLikeService articleLikeService;

	@Autowired
	TopicService topicService;

	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = { "/", "index" })
	public String welcome(Model model) {
		ArticleLikeExample example = new ArticleLikeExample();
		 
		List<ArticleWithBLOBs> articles = articleService.selectDetail(null);
		
		for (ArticleWithBLOBs article : articles) {
			example.clear();
			example.createCriteria().andArticleIdEqualTo(article.getId());
			article.setLikeNum(articleLikeService.countByExample(example));
			
		}

		List<ArticleWithBLOBs> article24Hot = articleService.select24Hot(null);

		List<ArticleWithBLOBs> hotCollect = articleService.selectHotCollect(null);
		
		List<Topic> hotTopics = topicService.selectHotTopic(null);
		
		
		User currentUser = UserUtils.getCurrentUser();
		
		if(currentUser != null ){
			MessageExample example6 = new MessageExample();
			Criteria criteria = example6.createCriteria();
			criteria.andDelFlagEqualTo(0);
			criteria.andStatusEqualTo(0);
			criteria.andRecIdEqualTo(UserUtils.getCurrentUserId());
			List<Message> unread = messageService.selectByExample(example6);
			model.addAttribute("unread", unread.size());
			
		}
		

		model.addAttribute("articles", articles);

		model.addAttribute("article24Hot", article24Hot);

		model.addAttribute("hotCollect", hotCollect);

		model.addAttribute("hotTopics", hotTopics);
		
		

		return "index";
	}

}
