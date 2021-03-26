package com.juhan.web.freeBoard.service;

import java.util.List;

import com.juhan.web.commons.PageVO;
import com.juhan.web.freeBoard.model.FreeBoardVO;

public interface IFreeBoardService {
	
	//get all Articles
	List<FreeBoardVO> getArticleList(PageVO page);
	
	//get one Article
	FreeBoardVO getArticle(int boardNo);
	
	//insert Article
	void insertArticle(FreeBoardVO article);
	
	//update Article
	void updateArticle(FreeBoardVO article);
	
	//delete Article
	void deleteArticle(int boardNo);
	
	//count up viewCnt
	void viewCntUp(int boardNo);
	
	//count all articles
	int countArticles();
}
