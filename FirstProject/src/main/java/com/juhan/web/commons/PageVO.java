package com.juhan.web.commons;

public class PageVO {

	private int currentPage;
	private int messagePerPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMessagePerPage() {
		return messagePerPage;
	}

	public void setMessagePerPage(int messagePerPage) {
		this.messagePerPage = messagePerPage;
	}

	public PageVO(int currentPage, int messagePerPage) {
		super();
		this.currentPage = currentPage;
		this.messagePerPage = messagePerPage;
	}

	public PageVO() {
		this.currentPage = 1;
		this.messagePerPage = 10;
	}
}
