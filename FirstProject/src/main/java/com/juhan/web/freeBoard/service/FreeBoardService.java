package com.juhan.web.freeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhan.web.commons.SearchVO;
import com.juhan.web.freeBoard.model.FreeBoardVO;
import com.juhan.web.freeBoard.repository.IFreeBoardMapper;

@Service
public class FreeBoardService implements IFreeBoardService {
	
	@Autowired
	private IFreeBoardMapper mapper;
	
	@Override
	public List<FreeBoardVO> getArticleList(SearchVO paging) {
		return mapper.getArticleList(paging);
	}

	@Override
	public FreeBoardVO getArticle(int boardNo) {
		return mapper.getArticle(boardNo);
	}

	@Override
	public void insertArticle(FreeBoardVO article) {
		mapper.insertArticle(article);
	}

	@Override
	public void updateArticle(FreeBoardVO article) {
		mapper.updateArticle(article);
	}

	@Override
	public void deleteArticle(int boardNo) {
		mapper.deleteArticle(boardNo);
	}
	
	@Override
	public void viewCntUp(int boardNo) {
		mapper.viewCntUp(boardNo);
	}
	
	@Override
	public int countArticles(SearchVO paging) {
		return mapper.countArticles(paging);
	}

}
