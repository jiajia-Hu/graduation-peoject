package com.shanzha.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shanzha.moduls.article.entity.ArticleWithBLOBs;
import com.shanzha.moduls.article.service.ArticleService;
import com.shanzha.moduls.sys.entity.UserProfile;
import com.shanzha.moduls.sys.service.UserProfileService;
import com.shanzha.moduls.topic.entity.Topic;
import com.shanzha.moduls.topic.service.TopicService;

@Controller
@RequestMapping("/image")
public class ImageController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${image.head}")
	String imagePath;

	@Value("${image.title}")
	String titlePath;

	@Value("${image.topic}")
	String topicImg;
	
	@Autowired
	UserProfileService userProfileService;

	@Autowired
	ArticleService articleService;
	
	@Autowired
	TopicService topicService;

	@RequestMapping("/head/{id}")
	public void headIamge(HttpServletResponse response, @PathVariable("id") Long id) {

		UserProfile userProfile = userProfileService.selectByPrimaryKey(id);
		String headImagePath = imagePath + userProfile.getHeadImage();

		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		OutputStream out = null;
		InputStream is = null;
		try {
			out = response.getOutputStream();
			File file = new File(headImagePath);
			is = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			is.read(data);
			out.write(data);
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}

	}

	
	
	
	
	@RequestMapping("/title/{id}")
		public void titleIamge(HttpServletResponse response, @PathVariable("id") Long id) {

		ArticleWithBLOBs article = articleService.selectByPrimaryKey(id);
		String titleImagePath = titlePath + article.getTitleImage();

		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		OutputStream out = null;
		InputStream is = null;
		try {
			out = response.getOutputStream();
			File file = new File(titleImagePath);
			is = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			is.read(data);
			out.write(data);
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}

	}
	
	
	
	@RequestMapping("/topic/{id}")	
	public void topicIamge(HttpServletResponse response, @PathVariable("id") Long id) {
		Topic topic = topicService.selectByPrimaryKey(id);
		String topicImagePath = topicImg + topic.getImage();

		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		OutputStream out = null;
		InputStream is = null;
		try {
			out = response.getOutputStream();
			File file = new File(topicImagePath);
			is = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			is.read(data);
			out.write(data);
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}

	}


}
