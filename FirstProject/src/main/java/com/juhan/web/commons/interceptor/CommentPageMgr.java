package com.juhan.web.commons.interceptor;

import com.juhan.web.commons.CommentPageVO;

public class CommentPageMgr {

	private CommentPageVO cPage;
	private int totalComment;
	private boolean prev;
	private boolean next;
	
	private final int displayPageBtn = 5;
	
	public CommentPageMgr(CommentPageVO cPage, int totalComment) {
		this.cPage = cPage;
		this.totalComment = totalComment;
		calc();
	}
	
	private void calc() {
		int totalPage = (int)Math.ceil(totalComment/(double)displayPageBtn);
		if(cPage.getcPage() < 1) {
			cPage.setcPage(1);
		}
		if(cPage.getcPage() > totalPage) {
			cPage.setcPage(totalPage);
		}
	}

	public CommentPageVO getcPage() {
		return cPage;
	}

	public void setcPage(CommentPageVO cPage) {
		this.cPage = cPage;
	}

	public int getTotalComment() {
		return totalComment;
	}

	public void setTotalComment(int totalComment) {
		this.totalComment = totalComment;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}
