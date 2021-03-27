package com.juhan.web.commons;

public class PageMgr {
	
	private PageVO page;
	private int beginPage;
	private int endPage;
	private int allArticleCnt;
	private int totalPage;
	private boolean prev;
	private boolean next;
	
	private final int displayPageBtn = 10;

	public PageMgr() {}
	
	public PageMgr(PageVO page, int allArticleCnt) {
		this.page = page;
		this.allArticleCnt = allArticleCnt;
		this.next = true;
		calcPageData();
	}
	
	private void calcPageData() {
		totalPage = (allArticleCnt>=1) ? (int)Math.ceil(allArticleCnt/(double)page.getMessagePerPage()) : 1;
		
		if(page.getCurrentPage() > totalPage) {
			page.setCurrentPage(totalPage);
		}
		
		endPage = (int)Math.ceil(page.getCurrentPage()/(double)displayPageBtn)*displayPageBtn;
		beginPage = endPage-displayPageBtn+1;
		
		prev = (beginPage > 1) ? true : false;
		if(endPage >= totalPage) {
			endPage = totalPage;
			next = false;
		}
	}
	
	public PageVO getPage() {
		return page;
	}

	public void setPage(PageVO page) {
		this.page = page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getAllArticleCnt() {
		return allArticleCnt;
	}

	public void setAllArticleCnt(int allArticleCnt) {
		this.allArticleCnt = allArticleCnt;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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