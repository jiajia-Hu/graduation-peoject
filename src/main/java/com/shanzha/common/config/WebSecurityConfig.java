package com.shanzha.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.shanzha.common.security.MyAuthenticationFailureHandler;
import com.shanzha.common.security.MyAuthenticationProvider;
import com.shanzha.common.security.MyAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private MyAuthenticationProvider provider;//自定义验证
	
	@Autowired
	MyAuthenticationSuccessHandler successHandler;
	
	@Autowired
	MyAuthenticationFailureHandler authenticationFailureHandler;
	
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      
		http.authorizeRequests()
            	.antMatchers("/**/*.js").permitAll()
            	.antMatchers("/**/*.css").permitAll()
            	.antMatchers("/**/*.png").permitAll()
            	.antMatchers("/**/*.woff").permitAll()
            	.antMatchers("/**/*.jpg").permitAll()
            	.antMatchers("/**/*.woff2").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/article/**/*").permitAll()
                .antMatchers("/image/**/*").permitAll()
                .antMatchers("/validateCode").permitAll()
                .antMatchers("/admin/**/*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/signin").successHandler(successHandler).failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/signin")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给自定义验证工具
        auth.authenticationProvider(provider);
    }
}

