package com.juhan.web.freeBoard.model;

import java.sql.Timestamp;

public class FreeBoardCommentVO {

	private int commentNo;
	private int boardNo;
	private String writer;
	private String content;
	private Timestamp regDate;

	public FreeBoardCommentVO() {
		// TODO Auto-generated constructor stub
	}

	public FreeBoardCommentVO(int commentNo, int boardNo, String writer, String content, Timestamp regDate) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "FreeBoardCommentVO [commentNo=" + commentNo + ", boardNo=" + boardNo + ", writer=" + writer
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}

}
