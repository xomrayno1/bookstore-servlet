package com.tampro.utils;

public class PaginationGeneric<T> {

	private int start;
	private int end;
	private int pageCurrent;
	private T listWishList;
	private T listWishPagation;
	private int soPage;
	private int limit;
	
	
	
	
	
	public T getListWishPagation() {
		return listWishPagation;
	}
	public void setListWishPagation(T listWishPagation) {
		this.listWishPagation = listWishPagation;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getSoPage() {
		return soPage;
	}
	public T getListWishList() {
		return listWishList;
	}
	public void setListWishList(T listWishList) {
		this.listWishList = listWishList;
	}
	public void setSoPage(int soPage) {
		this.soPage = soPage;
	}

	

	
	
	
	
	
	
	
}
