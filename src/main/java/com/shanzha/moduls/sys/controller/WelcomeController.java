package com.shanzha.moduls.sys.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shanzha.common.utils.CreateImageCode;
import com.shanzha.common.utils.PasswordUtils;
import com.shanzha.moduls.sys.entity.User;
import com.shanzha.moduls.sys.entity.User.Role;
import com.shanzha.moduls.sys.entity.UserPrincipal;
import com.shanzha.moduls.sys.entity.UserProfile;
import com.shanzha.moduls.sys.service.UserProfileService;
import com.shanzha.moduls.sys.service.UserService;

@Controller
public class WelcomeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserService userService;
	@Autowired
	UserProfileService userProfileService;

	@Autowired
	protected AuthenticationManager authenticationManager;

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() {

		return "signin";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/signin";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {

		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(User user, HttpServletRequest request) {
		String password = user.getPassword();
		String newPwd = PasswordUtils.entryptPassword(password);
		user.setPassword(newPwd);
		user.setUserRole(Role.USER);
		User userOld = userService.selectByUsername(user.getUsername());
		if (userOld != null) {

			return "redirect:signup?error";
		}
		user.setNickName("");
		
		userService.insert(user);
		
		UserProfile record = new UserProfile();
		record.setId(user.getId());
		record.setHeadImage("default.jpg");
		userProfileService.insert(record );
		
		
		UserPrincipal userPrincipal = new UserPrincipal(user);
		Collection<? extends GrantedAuthority> authorities = userPrincipal.getAuthorities();

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, password,
				authorities);

		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		request.getSession().setAttribute("user", user);

		return "redirect:/";
	}

	@RequestMapping("/validateCode")
	public void validateCode(HttpServletResponse response, HttpSession session) throws IOException {

		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		CreateImageCode vCode = new CreateImageCode(80, 30, 4, 10);
		session.setAttribute("validateCode", vCode.getCode());
		vCode.write(response.getOutputStream());
	}

	@RequestMapping("/weather")
	@ResponseBody
	public  Object weather(HttpServletResponse response, HttpSession session) {
		
		Map readValue = null;
		try {
			//大连代码101070201
			URI uri = new URI("http://www.weather.com.cn/data/cityinfo/101070201.html");
			SimpleClientHttpRequestFactory schr = new SimpleClientHttpRequestFactory();
			ClientHttpRequest chr = schr.createRequest(uri, HttpMethod.GET);
			ClientHttpResponse res = chr.execute();
			InputStream is = res.getBody(); // 获得返回数据,注意这里是个流
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			ObjectMapper objectMapper = new ObjectMapper();
			String str = br.readLine();
			readValue = objectMapper.readValue(str, Map.class);
		} catch (Exception e) {
			logger.error("获取天气失败");
		}	
		return readValue;
	}

}
