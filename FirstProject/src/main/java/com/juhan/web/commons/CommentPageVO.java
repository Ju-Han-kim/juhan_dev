package com.juhan.web.commons;

public class CommentPageVO {

	private int cPage;
	private final int messagePerPage = 5;

	public int getMessagePerPage() {
		return messagePerPage;
	}

	public CommentPageVO() {
		cPage = 1;
	}

	public int getcPage() {
		return cPage;
	}

	public void setcPage(int cPage) {
		this.cPage = cPage;
	}

}
