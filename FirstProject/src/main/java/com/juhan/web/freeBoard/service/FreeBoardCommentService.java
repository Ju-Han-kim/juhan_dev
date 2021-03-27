package com.juhan.web.freeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhan.web.freeBoard.model.FreeBoardCommentVO;
import com.juhan.web.freeBoard.repository.IFreeBoardCommentMapper;

@Service
public class FreeBoardCommentService implements IFreeBoardCommentService {

	@Autowired
	private IFreeBoardCommentMapper mapper;
	
	@Override
	public void insertComment(FreeBoardCommentVO comment) {
		mapper.insertComment(comment);
	}

	@Override
	public void updateComment(FreeBoardCommentVO comment) {
		mapper.updateComment(comment);
	}

	@Override
	public void deleteComment(int commentNo) {
		mapper.deleteComment(commentNo);
	}

	@Override
	public List<FreeBoardCommentVO> getComments(int boardNo) {
		return mapper.getComments(boardNo);
	}

}
