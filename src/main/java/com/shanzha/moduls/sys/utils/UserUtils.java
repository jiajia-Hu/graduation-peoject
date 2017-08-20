package com.shanzha.moduls.sys.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.shanzha.common.utils.SpringContextUtil;
import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.service.UserService;

public class UserUtils {

	public static User getCurrentUser() {
		User user = null;
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User){
			
			user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
		}
		return user;
	}

	public static Long getCurrentUserId() {
		User user = getCurrentUser();

		if (user != null) {
			return user.getId();
		}
		return 0L;
	}

	public static User getUserById(Long id) {
		UserService userService = SpringContextUtil.getBean(UserService.class);
		return userService.selectByPrimaryKey(id);

	}

}
