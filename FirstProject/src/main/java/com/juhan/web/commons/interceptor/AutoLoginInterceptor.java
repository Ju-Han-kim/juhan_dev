package com.juhan.web.commons.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.juhan.web.user.model.UserVO;
import com.juhan.web.user.service.IUserService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private IUserService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		Cookie autoLogin = WebUtils.getCookie(request, "autoLogin");
		
		if(autoLogin != null) {
			UserVO dbUser = service.selectOneWithSessionId(autoLogin.getValue());
			if(dbUser != null) {
				session.setAttribute("login", dbUser);
			}
		}
		return true;
	}

}







