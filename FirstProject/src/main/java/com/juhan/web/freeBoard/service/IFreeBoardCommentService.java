package com.juhan.web.freeBoard.service;

import java.util.List;

import com.juhan.web.commons.CommentPageVO;
import com.juhan.web.freeBoard.model.FreeBoardCommentVO;

public interface IFreeBoardCommentService {
	
	//댓글작성
	void insertComment(FreeBoardCommentVO comment);
	
	//댓글수정
	void updateComment(FreeBoardCommentVO comment);
	
	//댓글삭제
	void deleteComment(int commentNo);
	
	//게시글 별 댓글 읽어오기
	List<FreeBoardCommentVO> getComments(int boardNo, CommentPageVO cPage);
	
	//현재 게시글의 댓글 개수 가져오기
	int commentCount(int boardNo);
}
