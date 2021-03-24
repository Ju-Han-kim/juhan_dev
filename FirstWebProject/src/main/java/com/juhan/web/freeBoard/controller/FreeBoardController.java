package com.juhan.web.freeBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juhan.web.freeBoard.model.FreeBoardVO;
import com.juhan.web.freeBoard.service.IFreeBoardService;

@Controller
@RequestMapping("/board")
public class FreeBoardController {
	
	@Autowired
	private IFreeBoardService service;
	
	//자유게시판 mapping
	@GetMapping("/list")
	public String freeBoardList(Model model) {
		model.addAttribute("articles", service.getArticleList());
		return "freeBoard/list";
	}
	
	//글작성 양식 mapping
	@GetMapping("/write")
	public String freeBoardWrite() {
		return "freeBoard/write";
	}
	
	//글작성 mapping
	@PostMapping("/write")
	public String freeBoardWrite(FreeBoardVO article, RedirectAttributes ra) {
		service.insertArticle(article);
		ra.addFlashAttribute("msg", "insertSuccess");
		return "redirect:/board/list";
	}
	
	
	
	
	
}














