package com.juhan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//회원가입화면 mapping : 테스트용 매핑
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
}
