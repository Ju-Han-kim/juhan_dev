package com.juhan.web.user.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.juhan.web.user.model.UserVO;
import com.juhan.web.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/idchk")
	public int idchk(@RequestBody String userId) {
		return service.idCheck(userId);
	}
	
	@PostMapping("/join")
	public String join(@RequestBody UserVO user) {
		service.register(user);
		return "joinSuccess";
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("user/login");
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserVO user, HttpSession session, HttpServletResponse response) {
		
		BCryptPasswordEncoder encoding = new BCryptPasswordEncoder();
		UserVO dbUser = service.selectOne(user.getUserId());
		String result = "";
		
		if(dbUser != null) {
			if(encoding.matches(user.getPassword(), dbUser.getPassword())) {
				session.setAttribute("login", dbUser);
				
				//autoLogin
				if(user.isAutoLogin()) {
					long limitTime = 60 * 60 * 24 * 90;
					
					Cookie loginCookie = new Cookie("loginCookie", session.getId());
					loginCookie.setPath("/");
					loginCookie.setMaxAge((int)limitTime);
					
					long limitDateTime = System.currentTimeMillis() + (limitTime * 1000);
					Date limitDate = new Date(limitDateTime);
					service.setAutoLogin(user.getUserId(), session.getId(), limitDate);
					
					response.addCookie(loginCookie);
				}
				
				result = "loginSuccess";
			}else {
				result = "pwFail";
			}
		} else {
			result = "idFail";
		}
		return result;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session, HttpServletResponse response) {
		String id="";
		if(session.getAttribute("login") != null)
			id = ((UserVO)session.getAttribute("login")).getUserId();
		session.removeAttribute("login");
		Cookie loginCookie = new Cookie("loginCookie", null);
		
		if(loginCookie != null) {
			service.logout(id);
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	
	
	
	
}

















