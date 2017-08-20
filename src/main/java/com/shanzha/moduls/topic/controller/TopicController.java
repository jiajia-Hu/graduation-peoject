package com.shanzha.moduls.topic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shanzha.common.base.BaseController;
import com.shanzha.moduls.article.entity.ArticleExample;
import com.shanzha.moduls.article.entity.ArticleLikeExample;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.service.ArticleCollectService;
import com.shanzha.moduls.article.service.ArticleLikeService;
import com.shanzha.moduls.article.service.ArticleService;
import com.shanzha.moduls.sys.utils.UserUtils;
import com.shanzha.moduls.topic.entity.Topic;
import com.shanzha.moduls.topic.entity.TopicFollow;
import com.shanzha.moduls.topic.entity.TopicFollowExample;
import com.shanzha.moduls.topic.service.TopicFollowService;
import com.shanzha.moduls.topic.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController extends BaseController {
	
	@Autowired
	ArticleCollectService articleCollectService;
	
	@Autowired
	ArticleLikeService articleLikeService;

	@Autowired
	ArticleService articleService;

	@Autowired
	TopicService topicService;
	
	@Autowired
	TopicFollowService topicFollowService;
	
	@RequestMapping(value = "/follow", method = RequestMethod.GET)
	public String follow(Model model) {
		
		List<Topic> myTopics = topicService.selectMyFollow(UserUtils.getCurrentUserId());
		
		ArticleExample example2= new ArticleExample();
		List<Long> topicIds = new ArrayList<>();
		for(Topic topic :myTopics){
			topicIds.add(topic.getId());
		}
		
		example2.createCriteria().andTopicIn(topicIds);
		
		if(topicIds.isEmpty()){
			example2.clear();
		}
		
		List<ArticleWithBLOBs> articles = articleService.selectDetail(example2);
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

		model.addAttribute("myTopics", myTopics);
		
		return "topic_follow";
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String single(Model model ,@PathVariable("id") Long id) {
		ArticleExample example2 = new ArticleExample();
		example2.createCriteria().andTopicEqualTo(id);
		
		List<ArticleWithBLOBs> articles = articleService.selectDetail(example2);
		
		
		Topic topic = topicService.selectByPrimaryKey(id);
		
		ArticleLikeExample example = new ArticleLikeExample();
		for (ArticleWithBLOBs article : articles) {

			example.clear();
			example.createCriteria().andArticleIdEqualTo(article.getId());
			article.setLikeNum(articleLikeService.countByExample(example));

		}
		
		boolean follow = false;
		
		TopicFollowExample example3 = new TopicFollowExample();
		example3.createCriteria().andTopicIdEqualTo(topic.getId()).andUserIdEqualTo(UserUtils.getCurrentUserId());
		List<TopicFollow> topicFollows = topicFollowService.selectByExample(example3);
		
		follow = !topicFollows.isEmpty();
		List<ArticleWithBLOBs> article24Hot = articleService.select24Hot(null);

		List<ArticleWithBLOBs> hotCollect = articleService.selectHotCollect(null);

		List<Topic> hotTopics = topicService.selectHotTopic(null);

		model.addAttribute("articles", articles);

		model.addAttribute("article24Hot", article24Hot);

		model.addAttribute("hotCollect", hotCollect);

		model.addAttribute("hotTopics", hotTopics);

		model.addAttribute("topic", topic);

		model.addAttribute("follow", follow);
		
		return "topic_single";
	}
	
	
	@RequestMapping(value = "/addFollow")
	@ResponseBody
	public String addFollow(Model model,TopicFollow topic ) {
		
		topicFollowService.insert(topic);
		
		return "success";
	}
	
	@RequestMapping(value = "/cancelFollow")
	@ResponseBody
	public String cancelFollow(Model model,TopicFollow topic ) {
		
		TopicFollowExample example = new TopicFollowExample();
		example.createCriteria().andUserIdEqualTo(UserUtils.getCurrentUserId()).andTopicIdEqualTo(topic.getTopicId());
		
		topicFollowService.deleteByExample(example);
		
		return "success";
	}
	

}
