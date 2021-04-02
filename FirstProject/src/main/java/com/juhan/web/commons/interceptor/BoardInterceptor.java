package com.juhan.web.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.juhan.web.user.service.IUserService;

public class BoardInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private IUserService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			response.sendRedirect("/?msg=login");
			return false;
		}
		
		return true;
	}
	
	
}
