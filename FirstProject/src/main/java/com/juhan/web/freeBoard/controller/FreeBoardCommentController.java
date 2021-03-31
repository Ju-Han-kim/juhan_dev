package com.juhan.web.freeBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juhan.web.commons.SearchVO;
import com.juhan.web.freeBoard.service.IFreeBoardCommentService;

@Controller
@RequestMapping("/comment")
public class FreeBoardCommentController {
	
	@Autowired
	private IFreeBoardCommentService service;
	
	@GetMapping("/del/{commentNo}")
	public String delComment(@PathVariable int commentNo, SearchVO paging, 
							 int boardNo, RedirectAttributes ra) {
		service.deleteComment(commentNo);
		ra.addFlashAttribute("p", paging);
		ra.addFlashAttribute("msg", "commentDeleteSuccess");
		return "redirect:/board/content/"+boardNo;
	}
	
}
