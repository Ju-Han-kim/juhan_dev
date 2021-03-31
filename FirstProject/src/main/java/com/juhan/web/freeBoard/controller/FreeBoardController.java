package com.juhan.web.freeBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juhan.web.commons.PageMgr;
import com.juhan.web.commons.SearchVO;
import com.juhan.web.freeBoard.model.FreeBoardCommentVO;
import com.juhan.web.freeBoard.model.FreeBoardVO;
import com.juhan.web.freeBoard.service.IFreeBoardCommentService;
import com.juhan.web.freeBoard.service.IFreeBoardService;

@Controller
@RequestMapping("/board")
public class FreeBoardController {
	
	@Autowired
	private IFreeBoardService service;
	@Autowired
	private IFreeBoardCommentService cService;
	
	@GetMapping("/list")
	public String freeBoardList(SearchVO paging, Model model) {
		PageMgr pm = new PageMgr(paging, service.countArticles(paging));
		model.addAttribute("pm", pm);
		model.addAttribute("articles", service.getArticleList(paging));
		return "freeBoard/list";
	}
	
	//자유게시판 mapping<no paging>
	/*
	@GetMapping("/list")
	public String freeBoardList(Model model) {
		model.addAttribute("articles", service.getArticleList());
		return "freeBoard/list";
	}
	*/
	//자유게시판 mapping<no searching
	/*
	@GetMapping("/list")
	public String freeBoardList(PageVO page, Model model) {
		PageMgr pm = new PageMgr(page, service.countArticles());
		model.addAttribute("pm", pm);
		model.addAttribute("articles", service.getArticleList(page));
		return "freeBoard/list";
	}
	*/
	
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
	
	//글 상세보기 mapping
	@GetMapping("/content/{boardNo}")
	public String freeBoardContent(@PathVariable int boardNo,@ModelAttribute("p") SearchVO paging , Model model) {
		service.viewCntUp(boardNo);
		model.addAttribute("article", service.getArticle(boardNo));
		model.addAttribute("comments", cService.getComments(boardNo));
		return "freeBoard/content";
	}
	
	//댓글 작성하기 mapping
	@PostMapping("/content/{boardNo}")
	public String insertComment(@PathVariable int boardNo, SearchVO paging, 
								FreeBoardCommentVO comment, RedirectAttributes ra) {
		ra.addFlashAttribute("msg", "commentInsertSuccess");
		ra.addFlashAttribute("p", paging);
		cService.insertComment(comment);
		return "redirect:/board/content/"+boardNo;
	}
	
	
	//글 삭제 mapping
	@PostMapping("/delete")
	public String freeBoardDelete(int boardNo, RedirectAttributes ra) {
		service.deleteArticle(boardNo);
		ra.addAttribute("msg", "deleteSuccess");
		return "redirect:/board/list";
	}
	
	//글 수정 양식 호출 mapping
	@GetMapping("/update")
	public String update(FreeBoardVO article, @ModelAttribute("p") SearchVO paging, Model model) {
		model.addAttribute("article", service.getArticle(article.getBoardNo()));
		return "freeBoard/update";
	}
	
	//글 수정 반영 mapping
	@PostMapping("/update")
	public String update(FreeBoardVO article, RedirectAttributes ra) {
		service.updateArticle(article);
		ra.addFlashAttribute("msg","updateSuccess");
		return "redirect:/board/content/"+article.getBoardNo();
	}
	
	
	
}









