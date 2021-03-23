package com.juhan.web.freeBoard.model;

import java.sql.*;

public class FreeBoardVO {
	
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private Timestamp regDate;
	private int viewCnt;
	
	public FreeBoardVO() {}

	public FreeBoardVO(int boardNo, String title, String wrtier, String content, Timestamp regDate, int viewCnt) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.writer = wrtier;
		this.content = content;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWrtier() {
		return writer;
	}

	public void setWrtier(String wrtier) {
		this.writer = wrtier;
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

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "FreeBoardVO [boardNo=" + boardNo + ", title=" + title + ", wrtier=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}
	
}
