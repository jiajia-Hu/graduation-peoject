package com.shanzha.moduls.article.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shanzha.common.base.BaseController;
import com.shanzha.moduls.article.entity.ArticleCollect;
import com.shanzha.moduls.article.entity.ArticleComment;
import com.shanzha.moduls.article.entity.ArticleCommentExample;
import com.shanzha.moduls.article.entity.ArticleCommentLike;
import com.shanzha.moduls.article.entity.ArticleCommentLikeExample;
import com.shanzha.moduls.article.entity.ArticleCommentLikeExample.Criteria;
import com.shanzha.moduls.article.entity.ArticleExample;
import com.shanzha.moduls.article.entity.ArticleLike;
import com.shanzha.moduls.article.entity.ArticleLikeExample;
import com.shanzha.moduls.article.entity.ArticleReport;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.entity.CommentReport;
import com.shanzha.moduls.article.entity.InviteAnswer;
import com.shanzha.moduls.article.entity.InviteAnswerExample;
import com.shanzha.moduls.article.service.ArticleCollectService;
import com.shanzha.moduls.article.service.ArticleCommentLikeService;
import com.shanzha.moduls.article.service.ArticleCommentService;
import com.shanzha.moduls.article.service.ArticleLikeService;
import com.shanzha.moduls.article.service.ArticleReportService;
import com.shanzha.moduls.article.service.ArticleService;
import com.shanzha.moduls.article.service.CommentReportService;
import com.shanzha.moduls.article.service.InviteAnswerService;
import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.service.UserService;
import com.shanzha.moduls.sys.utils.UserUtils;
import com.shanzha.moduls.topic.entity.Topic;
import com.shanzha.moduls.topic.service.TopicService;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
	@Autowired
	ArticleService articleService;

	@Autowired
	ArticleCommentService articleCommentService;

	@Autowired
	TopicService topicService;

	@Autowired
	ArticleCommentLikeService articleCommentLikeService;

	@Autowired
	ArticleLikeService articleLikeService;

	@Autowired
	ArticleCollectService articleCollectService;

	@Autowired
	CommentReportService commentReportService;

	@Autowired
	ArticleReportService articleReportService;

	@Autowired
	UserService userService;

	@Autowired
	InviteAnswerService inviteAnswerService;

	@Value("${image.title}")
	String imagePath;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newArticle(Model model) {

		List<Topic> topics = topicService.selectByExample(null);
		model.addAttribute("topics", topics);

		return "new_article";
	}

	@RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
	public String single(@PathVariable("id") Long id, Model model) {

		ArticleExample example = new ArticleExample();
		example.createCriteria().andIdEqualTo(id, "a");

		List<ArticleWithBLOBs> articles = articleService.selectDetail(example);

		ArticleCommentExample example2 = new ArticleCommentExample();
		example2.createCriteria().andArticleIdEqualTo(id);

		List<ArticleComment> comments = articleCommentService.selectByExampleWithBLOBs(example2);

		ArticleCommentLikeExample example3 = new ArticleCommentLikeExample();

		for (ArticleComment articleComment : comments) {
			articleComment.setUserName(UserUtils.getUserById(articleComment.getUserId()).getNickName());
			if (articleComment.getReplyUser() != 0) {
				articleComment.setReplyUserName(UserUtils.getUserById(articleComment.getReplyUser()).getNickName());
			}
			example3.clear();
			Criteria createCriteria = example3.createCriteria();
			createCriteria.andCommentIdEqualTo(articleComment.getId());
			articleComment.setLike(articleCommentLikeService.countByExample(example3));
		}

		ArticleWithBLOBs articleWithBLOBs = articles.get(0);

		ArticleLikeExample example4 = new ArticleLikeExample();

		example4.createCriteria().andArticleIdEqualTo(articleWithBLOBs.getId());
		articleWithBLOBs.setLikeNum(articleLikeService.countByExample(example4));

		List<ArticleWithBLOBs> articleRelated = articleService.selectRelacted(null);

		for (ArticleWithBLOBs article : articleRelated) {
			if (article.getTopic() == null) {
				article.setTopic(1l);

			}
			article.setTopicName(topicService.selectByPrimaryKey(article.getTopic()).getName());
		}

		List<User> users = userService.selectByExample(null);

		model.addAttribute("article", articleWithBLOBs);

		model.addAttribute("articleRelated", articleRelated);

		model.addAttribute("comments", comments);

		model.addAttribute("users", users);

		return "single_post";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ArticleWithBLOBs article, @RequestParam(value = "file", required = false) MultipartFile file) {

		if (file != null && !file.isEmpty()) {
			String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
			article.setTitleImage(fileName);

			File oFile = new File(imagePath + fileName);
			try {
				FileCopyUtils.copy(file.getBytes(), oFile);
			} catch (IOException e) {
				logger.error("upload title image error");
			}

		}
		articleService.insert(article);
		return "redirect:/article/single/" + article.getId();

	}

	@RequestMapping(value = "/comment")
	@ResponseBody
	public String comment(Model model, ArticleComment article) {

		article.setCommentDate(new Date());
		article.setLikeNumber(0);
		article.setUserId(UserUtils.getCurrentUserId());

		articleCommentService.insert(article);

		return "success";
	}

	@RequestMapping(value = "/comment_delete")
	@ResponseBody
	public String deleteComment(Long id) {
		articleCommentService.deleteByPrimaryKey(id);
		return "success";
	}
	
	
	
	
	@RequestMapping(value = "/comment_like")
	@ResponseBody
	public String commentLike(Model model, ArticleCommentLike articleCommentLike) {
		articleCommentLikeService.insert(articleCommentLike);

		return "success";
	}

	@RequestMapping(value = "/comment_report")
	@ResponseBody
	public String commentReport(Model model, CommentReport commentReport) {
		commentReportService.insert(commentReport);
		return "success";
	}

	@RequestMapping(value = "/like")
	@ResponseBody
	public String like(Model model, ArticleLike articleLike) {
		articleLikeService.insert(articleLike);
		return "success";
	}

	@RequestMapping(value = "/collect")
	@ResponseBody
	public String likcollecte(Model model, ArticleCollect articleCollect) {

		articleCollectService.insert(articleCollect);
		return "success";
	}

	@RequestMapping(value = "/report")
	@ResponseBody
	public String report(Model model, ArticleReport articleReport) {
		articleReportService.insert(articleReport);
		return "success";
	}

	@RequestMapping(value = "/invite")
	@ResponseBody
	public String invite(Model model, InviteAnswer inviteAnswer) {
		inviteAnswerService.insert(inviteAnswer);
		return "success";
	}
	
	@RequestMapping("/inviteme")
	public String inviteme(Model model) {

		ArticleExample example2 = new ArticleExample();
		List<Long> values = new ArrayList<>();
		example2.createCriteria().andIdIn(values, "a");
		
		InviteAnswerExample example4 = new InviteAnswerExample();
		example4.createCriteria().andInvitedIdEqualTo(UserUtils.getCurrentUserId());
		List<InviteAnswer> invites = inviteAnswerService.selectByExample(example4);

		for( InviteAnswer inviteAnswer : invites){
			values.add(inviteAnswer.getArticleId());
		}
		
		if(values.isEmpty()){
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

		return "invite_me";
	}

	@RequestMapping("/search/{title}")
	public String search(@PathVariable("title") String title,Model model){
		ArticleExample example = new ArticleExample();
		example.createCriteria().andTitleLike("%"+title+"%");
		List<ArticleWithBLOBs> articles = articleService.selectDetail(example);
		List<ArticleWithBLOBs> article24Hot = articleService.select24Hot(null);

		List<ArticleWithBLOBs> hotCollect = articleService.selectHotCollect(null);
		
		List<Topic> hotTopics = topicService.selectHotTopic(null);
		model.addAttribute("articles", articles);
		model.addAttribute("article24Hot", article24Hot);

		model.addAttribute("hotCollect", hotCollect);

		model.addAttribute("hotTopics", hotTopics);
		return "article_search";
		
	}
}
