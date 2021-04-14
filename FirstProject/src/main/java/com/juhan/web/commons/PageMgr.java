package com.juhan.web.commons;

import org.springframework.web.util.UriComponentsBuilder;

public class PageMgr {
	
	private PageVO page;
	private int beginPage;
	private int endPage;
	private int allArticleCnt;
	private int totalPage;
	private boolean prev;
	private boolean next;
	
	private final int displayPageBtn = 5;
	
	//uri 작성 method
	public String makeUri(int currentPage) {
		String uri = UriComponentsBuilder.newInstance()
							.queryParam("currentPage", currentPage)
							.queryParam("messagePerPage", page.getMessagePerPage())
							.queryParam("part", ((SearchVO)page).getPart())
							.queryParam("keyword", ((SearchVO)page).getKeyword())
							.build().toUriString();
		return uri;
	}

	public PageMgr() {}
	
	public PageMgr(PageVO page, int allArticleCnt) {
		this.page = page;
		this.allArticleCnt = allArticleCnt;
		this.prev = true;
		this.next = true;
		calcPageData();
	}
	
	private void calcPageData() {
		totalPage = (allArticleCnt>=1) ? (int)Math.ceil(allArticleCnt/(double)page.getMessagePerPage()) : 1;
		
		if(page.getCurrentPage() > totalPage) {
			page.setCurrentPage(totalPage);
		}
		
		endPage = page.getCurrentPage() + displayPageBtn/2;
		beginPage = endPage-displayPageBtn+1;
		
		if(totalPage > displayPageBtn) {
			int tem = 0;
			if(beginPage <= 1) {
				tem = 1 - beginPage;
				prev = false;
			}else if(endPage >= totalPage) {
				tem = totalPage - endPage;
				next = false;
			}
			beginPage += tem;
			endPage += tem;
		}else {
			beginPage = 1;
			endPage = totalPage;
			prev = false;
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
