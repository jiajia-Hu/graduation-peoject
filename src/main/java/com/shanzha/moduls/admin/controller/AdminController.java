package com.shanzha.moduls.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shanzha.moduls.admin.entity.Admin;
import com.shanzha.moduls.admin.entity.AdminExample;
import com.shanzha.moduls.admin.entity.Notice;
import com.shanzha.moduls.admin.service.AdminService;
import com.shanzha.moduls.admin.service.NoticeService;
import com.shanzha.moduls.article.entity.ArticleExample;
import com.shanzha.moduls.article.entity.ArticleReport;
import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.service.ArticleReportService;
import com.shanzha.moduls.article.service.ArticleService;
import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	NoticeService noticeService;

	@Autowired
	UserService userService;

	@Autowired
	ArticleService articleService;

	@Autowired
	ArticleReportService articleReportService;

	@RequestMapping(value = {"/index",""}, method = RequestMethod.GET)
	public String index() {

		return "admin/index";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {

		return "admin/user";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {

		return "admin/admin";
	}

	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String article() {

		return "admin/article";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report() {

		return "admin/report";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {

		return "admin/signin";
	}

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice() {

		return "admin/notice";
	}

	@RequestMapping(value = "/users")
	@ResponseBody
	public List<User> users() {

		List<User> users = userService.selectByExample(null);

		return users;
	}

	@RequestMapping(value = "/admins")
	@ResponseBody
	public List<Admin> admins() {

		List<Admin> users = adminService.selectByExample(null);

		return users;
	}

	@RequestMapping(value = "/atricles")
	@ResponseBody
	public List<ArticleWithBLOBs> articles() {

		List<ArticleWithBLOBs> articles = articleService.selectDetail(null);

		return articles;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String doSignin(Admin admin,Model model) {

		AdminExample example = new AdminExample();
		example.createCriteria().andUsernameEqualTo(admin.getUsername()).andPassowrdEqualTo(admin.getPassowrd());

		List<Admin> admins = adminService.selectByExample(example);
		
		if(admins.isEmpty()){
			model.addAttribute("error","用户名密码不正确");
			return "admin/signin";
		}

		return "redirect:/admin/index";
	}

	@RequestMapping(value = "/enable")
	@ResponseBody
	public String enable(User user) {
		userService.updateByPrimaryKeySelective(user);

		return "success";
	}

	@RequestMapping(value = "/insert")
	public String insert(Admin admin) {
		admin.setEnable(1);
		admin.setPassowrd("admin");
		adminService.insert(admin);

		return "redirect:/admin/admin";
	}

	@RequestMapping(value = "/enableAdmin")
	@ResponseBody
	public String enableAdmin(Admin user) {
		adminService.updateByPrimaryKeySelective(user);

		return "success";
	}

	@RequestMapping(value = "/deleteArticle")
	@ResponseBody
	public String deleteArticle(Long id) {
		articleService.deleteByPrimaryKey(id);

		return "success";
	}

	@RequestMapping(value = "/cancelReport")
	@ResponseBody
	public String cancelReport(Long id) {
		articleReportService.deleteByPrimaryKey(id);

		return "success";
	}

	@RequestMapping(value = "/reports")
	@ResponseBody
	public List<Map<String, Object>> reports() {

		List<Map<String, Object>> list = new ArrayList<>();
		List<ArticleReport> reporst = articleReportService.selectByExample(null);

		for (ArticleReport articleReport : reporst) {
			ArticleExample example = new ArticleExample();
			example.createCriteria().andIdEqualTo(articleReport.getArticleId(), "a");
			List<ArticleWithBLOBs> selectDetail = articleService.selectDetail(example);
			if (selectDetail.isEmpty()) {
				continue;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("id", articleReport.getId());
			map.put("reportReason", articleReport.getReportReason());
			map.put("reportUser", userService.selectByPrimaryKey(articleReport.getUserId()).getNickName());

			map.put("article", selectDetail.get(0));
			list.add(map);
		}
		return list;
	}

	@RequestMapping(value = "/notices")
	@ResponseBody
	public List<Notice> notices() {
		List<Notice> notes = noticeService.selectByExample(null);

		return notes;
	}

	@RequestMapping(value = "/publisNotcie")
	public String publisNotcie(Notice notice) {
		notice.setPublishDate(new Date());
		noticeService.insert(notice);

		return "redirect:/admin/notice";
	}

	@RequestMapping(value = "/deleteNotice")
	@ResponseBody
	public String deleteNotice(Long id) {
		noticeService.deleteByPrimaryKey(id);

		return "success";
	}
}
