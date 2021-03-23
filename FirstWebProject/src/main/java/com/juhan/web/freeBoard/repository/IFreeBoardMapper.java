package com.juhan.web.freeBoard.repository;

import java.util.*;

import com.juhan.web.freeBoard.model.FreeBoardVO;

public interface IFreeBoardMapper {
	
	//get all Articles
	List<FreeBoardVO> getArticleList();
	
	//get one Article
	FreeBoardVO getArticle(int boardNo);
	
	//insert Article
	void insertArticle(FreeBoardVO article);
	
	//update Article
	void updateArticle(FreeBoardVO article);
	
	//delete Article
	void deleteArticle(int boardNo);
	
}
