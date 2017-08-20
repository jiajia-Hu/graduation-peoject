package com.shanzha.common.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.service.UserService;

@Configuration
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User user = (User) authentication.getPrincipal();

		if (user.getLastLogin() == null) {
			response.sendRedirect("/user/profile/edit");	
			return;
		}

		user.setLastLogin(new Date());
		user.setLoginIp(request.getRemoteAddr());

		userService.updateByPrimaryKey(user);
		
		request.getSession().removeAttribute("SIGNINERROR");

		response.sendRedirect("/");

	}

}
