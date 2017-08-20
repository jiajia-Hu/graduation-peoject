package com.shanzha.moduls.message.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shanzha.moduls.admin.entity.Notice;
import com.shanzha.moduls.admin.service.NoticeService;
import com.shanzha.moduls.message.entity.Message;
import com.shanzha.moduls.message.entity.MessageExample;
import com.shanzha.moduls.message.entity.MessageExample.Criteria;
import com.shanzha.moduls.message.entity.MessageExtend;
import com.shanzha.moduls.message.service.MessageService;
import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.entity.UserExample;
import com.shanzha.moduls.sys.service.UserService;
import com.shanzha.moduls.sys.utils.UserUtils;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@Autowired
	NoticeService noticeService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String send(Model model) {
		setInboxNum(model, UserUtils.getCurrentUserId());
		return "send";
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String doSend(Message message) {

		message.setCollect(0);
		message.setDelFlag(0);
		message.setSendDate(new Date());
		message.setSendId(UserUtils.getCurrentUserId());
		message.setStatus(0);

		messageService.insert(message);

		return "redirect:/message/inbox/send";
	}

	private void setInboxNum(Model model, Long id) {
		MessageExample example = new MessageExample();
		Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(0);
		criteria.andStatusEqualTo(0);
		criteria.andRecIdEqualTo(id);
		List<Message> unread = messageService.selectByExample(example);

		criteria.getCriteria().clear();
		criteria.andDelFlagEqualTo(1);
		criteria.andRecIdEqualTo(id);
		List<Message> deleted = messageService.selectByExample(example);

		criteria.getCriteria().clear();
		criteria.andDelFlagEqualTo(0);
		criteria.andRecIdEqualTo(id);
		criteria.andCollectEqualTo(1);
		List<Message> collect = messageService.selectByExample(example);

		model.addAttribute("unread", unread.size());
		model.addAttribute("deleted", deleted.size());
		model.addAttribute("collect", collect.size());
	}

	@RequestMapping("/inbox")
	public String inbox(Model model) {

		Long id = UserUtils.getCurrentUser().getId();
		Message message = new Message();
		message.setRecId(id);
		message.setDelFlag(0);
		List<MessageExtend> messages = messageService.selectExtend(message);

		setInboxNum(model, id);

		model.addAttribute("messages", messages);
		model.addAttribute("page", "inbox");
		return "inbox";
	}

	@RequestMapping("/inbox/{page}")
	public String inbox(Model model, @PathVariable("page") String page) {

		Long id = UserUtils.getCurrentUser().getId();
		List<MessageExtend> messages = null;

		Message message = new Message();
		message.setDelFlag(0);
		if ("send".equals(page)) {
			message.setSendId(id);
		} else if ("trash".equals(page)) {
			message.setRecId(id);
			message.setDelFlag(1);
		} else if ("collect".equals(page)) {
			message.setRecId(id);
			message.setCollect(1);
		}

		messages = messageService.selectExtend(message);
		setInboxNum(model, id);

		model.addAttribute("messages", messages);
		model.addAttribute("page", page);
		return "inbox";
	}

	@RequestMapping(value = "/messages")
	@ResponseBody
	public List<MessageExtend> messages(String flag) {
		List<MessageExtend> messages = new ArrayList<>();
		Message message = new Message();
		if ("inbox".equals(flag)) {
			message.setRecId(UserUtils.getCurrentUserId());
			messages = messageService.selectExtend(message);
		} else if ("send".equals(flag)) {
			message.setSendId(UserUtils.getCurrentUserId());
			messages = messageService.selectExtend(message);
			
			for(MessageExtend msg : messages){
				
				msg.setNickName(UserUtils.getUserById(msg.getRecId()).getNickName());
			}
			
		}else if ("notice".equals(flag)) {
			List<Notice> notices = noticeService.selectByExample(null);
			
			for(Notice notice : notices){
				MessageExtend e = new MessageExtend();
				e.setTitle(notice.getTitle());
				e.setMessage(notice.getContent());
				e.setSendDate(notice.getPublishDate());
				messages.add(e);
				
			}
			
		}
		
		return messages;
	}

	@RequestMapping(value = "/collect")
	@ResponseBody
	public Integer collect(Long id) {

		Message message = messageService.selectByPrimaryKey(id);
		message.setCollect(message.getCollect() ^ 1);
		int result = messageService.updateByPrimaryKeySelective(message);
		return result;
	}

	@RequestMapping(value = "/checkName")
	@ResponseBody
	public User checkName(String nickName) {
		UserExample userExample = new UserExample();
		com.shanzha.moduls.sys.entity.UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andNickNameEqualTo(nickName);
		List<User> users = userService.selectByExample(userExample);
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public Integer delete(Long id) {

		int result = messageService.deleteByPrimaryKey(id);

		return result;
	}
	@RequestMapping(value = "/read")
	@ResponseBody
	public Integer read(Long id) {
		
		Message record = new Message();
		record.setId(id);
		record.setStatus(1);
		int result = messageService.updateByPrimaryKeySelective(record);
		
		return result;
	}

}
