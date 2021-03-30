package com.juhan.web.commons;

public class SearchVO extends PageVO{
	
	private String part;
	private String keyword;

	public SearchVO() {
		this.part = "";
		this.keyword = "";
	}

	public SearchVO(int currentPage, int messagePerPage, String part, String keyword) {
		super(currentPage, messagePerPage);
		this.part = part;
		this.keyword = keyword;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchVO [part=" + part + ", keyword=" + keyword + "]";
	}
	
}
