package com.shanzha.moduls.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.shanzha.moduls.article.entity.ArticleExample;
import com.shanzha.moduls.article.entity.ArticleLike;
import com.shanzha.moduls.article.entity.ArticleLikeExample;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.entity.InviteAnswer;
import com.shanzha.moduls.article.entity.InviteAnswerExample;
import com.shanzha.moduls.article.service.ArticleCollectService;
import com.shanzha.moduls.article.service.ArticleLikeService;
import com.shanzha.moduls.article.service.ArticleService;
import com.shanzha.moduls.article.service.InviteAnswerService;
import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.entity.UserFollow;
import com.shanzha.moduls.sys.entity.UserFollowExample;
import com.shanzha.moduls.sys.entity.UserPrincipal;
import com.shanzha.moduls.sys.entity.UserProfile;
import com.shanzha.moduls.sys.service.UserFollowService;
import com.shanzha.moduls.sys.service.UserProfileService;
import com.shanzha.moduls.sys.service.UserService;
import com.shanzha.moduls.sys.utils.UserUtils;
import com.shanzha.moduls.topic.entity.Topic;
import com.shanzha.moduls.topic.entity.TopicFollow;
import com.shanzha.moduls.topic.service.TopicService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	ArticleCollectService articleCollectService;

	@Autowired
	ArticleLikeService articleLikeService;

	@Autowired
	ArticleService articleService;

	@Autowired
	TopicService topicService;
	
	@Autowired
	UserFollowService userFollowService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	InviteAnswerService inviteAnswerService;
	

	@Value("${image.head}")
	String imagePath;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String userProfile(Model model) {
		User user = UserUtils.getCurrentUser();
		
		ArticleExample example = new ArticleExample();
		List<Long> values = new ArrayList<>();
		
		example.createCriteria().andIdIn(values, "a");
		
		ArticleLikeExample example2 = new ArticleLikeExample();
		example2.createCriteria().andUserIdEqualTo(user.getId());
		
		List<ArticleLike> articleLikes = articleLikeService.selectByExample(example2);
		
		for( ArticleLike articleLike : articleLikes){
			values.add(articleLike.getArticleId());
		}
		
		if(values.isEmpty()){
			example.clear();
		}
		
		List<ArticleWithBLOBs> articles = articleService.selectDetail(example);
		if(values.isEmpty()){
			
			articles.clear();	
			
		}
		for(ArticleWithBLOBs articleWithBLOBs : articles){
			
			ArticleLikeExample articleLikeExample = new ArticleLikeExample();
			articleLikeExample.createCriteria().andArticleIdEqualTo(articleWithBLOBs.getId())
			.andUserIdEqualTo(UserUtils.getCurrentUserId());
			
			List<ArticleLike> selectByExample = articleLikeService.selectByExample(articleLikeExample);
			
			articleWithBLOBs.setLikeDate(selectByExample.get(0).getLikeDate());
			
		}
		
		
		
		
		
		UserProfile userProfile = userProfileService.selectByPrimaryKey(user.getId());
		
		example.clear();
		example.createCriteria().andAuthorEqualTo(user.getId(),"a");
		
		List<ArticleWithBLOBs> myArticles = articleService.selectDetail(example);
		
		List<UserProfile> myFollows = new ArrayList<>();
		
		UserFollowExample example3 = new UserFollowExample();
		example3.createCriteria().andUserIdEqualTo(user.getId());
		
		List<UserFollow> userFollows = userFollowService.selectByExample(example3 );
		
		for(UserFollow userFollow : userFollows){
			
			User user2  = userService.selectByPrimaryKey(userFollow.getFollowId());
			
			UserProfile userProfile2 = userProfileService.selectByPrimaryKey(userFollow.getFollowId());
			
			userProfile2.setNickName(user2.getNickName());
			
			myFollows.add(userProfile2);
			
		}
		
		InviteAnswerExample example4 = new InviteAnswerExample();
		example4.createCriteria().andInvitedIdEqualTo(UserUtils.getCurrentUserId());
		List<InviteAnswer> invites = inviteAnswerService.selectByExample(example4);
		
		values.clear();
		

		for( InviteAnswer inviteAnswer : invites){
			values.add(inviteAnswer.getArticleId());
		}
		example.clear();
		example.createCriteria().andIdIn(values, "a");
		
		if(values.isEmpty()){
			example.clear();
		}
		
		List<ArticleWithBLOBs> inviteArticles = articleService.selectDetail(example);
		

		model.addAttribute("articleLikes", articleLikes);
		
		model.addAttribute("userProfile", userProfile);
		
		model.addAttribute("articles", articles);
		
		model.addAttribute("myArticles", myArticles);
		
		model.addAttribute("invite", inviteArticles);
		
		model.addAttribute("myFollows", myFollows);
		
		return "profile";
	}

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public String userProfileById(Model model, @PathVariable("id") Long id) {

		ArticleExample example = new ArticleExample();
		List<Long> values = new ArrayList<>();
		
		example.createCriteria().andIdIn(values, "a");
		
		ArticleLikeExample example2 = new ArticleLikeExample();
		example2.createCriteria().andUserIdEqualTo(id);
		
		List<ArticleLike> articleLikes = articleLikeService.selectByExample(example2);
		
		for( ArticleLike articleLike : articleLikes){
			values.add(articleLike.getArticleId());
		}
		
		if(values.isEmpty()){
			example.clear();
		}
		List<ArticleWithBLOBs> articles = articleService.selectDetail(example);
		
		if(values.isEmpty()){
			
			articles.clear();	
			
		}
		for(ArticleWithBLOBs articleWithBLOBs : articles){
			
			ArticleLikeExample articleLikeExample = new ArticleLikeExample();
			articleLikeExample.createCriteria().andArticleIdEqualTo(articleWithBLOBs.getId())
			.andUserIdEqualTo(id);
			
			List<ArticleLike> selectByExample = articleLikeService.selectByExample(articleLikeExample);
			
			articleWithBLOBs.setLikeDate(selectByExample.get(0).getLikeDate());
			
		}
		
		
		UserProfile userProfile = userProfileService.selectByPrimaryKey(id);
		
		User uu = userService.selectByPrimaryKey(userProfile.getId());
		example.clear();
		example.createCriteria().andAuthorEqualTo(id,"a");
		
		List<ArticleWithBLOBs> myArticles = articleService.selectDetail(example);
		
		List<UserProfile> myFollows = new ArrayList<>();
		
		UserFollowExample example3 = new UserFollowExample();
		example3.createCriteria().andUserIdEqualTo(id);
		
		List<UserFollow> userFollows = userFollowService.selectByExample(example3 );
		
		for(UserFollow userFollow : userFollows){
			
			User user2  = userService.selectByPrimaryKey(userFollow.getFollowId());
			
			UserProfile userProfile2 = userProfileService.selectByPrimaryKey(userFollow.getFollowId());
			
			userProfile2.setNickName(user2.getNickName());
			
			myFollows.add(userProfile2);
			
		}
		
		model.addAttribute("uu", uu);
		
		model.addAttribute("userProfile", userProfile);
		
		model.addAttribute("articles", articles);
		
		model.addAttribute("articleLikes", articleLikes);
		
		model.addAttribute("myArticles", myArticles);
		
		model.addAttribute("myFollows", myFollows);
		return "profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String userProfileEdit(Model model) {
		User user = UserUtils.getCurrentUser();

		UserProfile userProfile = userProfileService.selectByPrimaryKey(user.getId());

		model.addAttribute("userProfile", userProfile);
		return "profile_edit";
	}

	@RequestMapping(value = "/profile/save", method = RequestMethod.POST)
	public String userProfileSave(Model model, UserProfile userProfile,
			@RequestParam(value = "file", required = false) MultipartFile file,@RequestParam(value = "nickName", required = false) String nickName) {
		User user = UserUtils.getCurrentUser();
		user.setLastLogin(new Date());
		if(!"".equals(nickName) && nickName != null){
			user.setNickName(nickName);
		}
		userService.updateByPrimaryKey(user);
		if(file != null && !"".equals(file.getOriginalFilename())){
			String headImage = UUID.randomUUID().toString() + file.getOriginalFilename();
			userProfile.setHeadImage(headImage);
			File oFile = new File(imagePath + headImage);
			try {
				FileCopyUtils.copy(file.getBytes(), oFile);
			} catch (IOException e) {
				logger.error("upload title image error");
			}
		}
		userProfile.setId(user.getId());
		userProfileService.updateByPrimaryKeySelective(userProfile);

		model.addAttribute("userProfile", userProfile);
		return "redirect:/user/profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	@ResponseBody
	public User getUserProfile() {
		User user = new User();
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		user.setUsername(userPrincipal.getUsername());

		return user;
	}

	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public User forget() {
		User user = new User();
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		user.setUsername(userPrincipal.getUsername());

		return user;
	}

	@RequestMapping(value = "/collect", method = RequestMethod.GET)
	public String collect(Model model) {
		List<ArticleWithBLOBs> articles = articleCollectService.selectMyCollection(UserUtils.getCurrentUserId());
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

		return "collect";
	}
	
	//对用户添加关注
	@RequestMapping(value = "/addFollow")
	@ResponseBody
	public String addFollow(Model model,UserFollow user ) {
		
		userFollowService.insert(user);
		
		return "success";
	}
}
