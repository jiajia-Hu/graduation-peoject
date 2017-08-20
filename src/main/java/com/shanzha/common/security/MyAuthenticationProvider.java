package com.shanzha.common.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.shanzha.common.utils.PasswordUtils;
import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.entity.UserPrincipal;
import com.shanzha.moduls.sys.service.UserService;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UserService userService;

	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	/**
	 * 自定义验证方式
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		User user = userService.selectByUsername(username);
		if (user == null) {
			throw new BadCredentialsException("用户不存在.");
		}
		

		// 加密过程在这里体现
		if (!PasswordUtils.validatePassword(password, user.getPassword())) {
			throw new BadCredentialsException("密码错误.");
		}
		String validateCode = (String) request.getSession().getAttribute("validateCode");
		String verify = (String) request.getParameter("verify");
		if(!verify.equalsIgnoreCase(validateCode)){
			throw new BadCredentialsException("验证码输入错误.");
		}
		
		if(user.getEnabled()== 0){
			throw new BadCredentialsException("对不起，你的帐号被冻结了.");
		}
		
		UserPrincipal userPrincipal = new UserPrincipal(user);
		Collection<? extends GrantedAuthority> authorities = userPrincipal.getAuthorities();
		
		session.setAttribute("user", user);
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
		
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
