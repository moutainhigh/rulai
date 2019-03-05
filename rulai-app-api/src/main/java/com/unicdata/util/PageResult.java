package com.unicdata.util;

/**
 * 分页工具类
 * @author admin
 */
public class PageResult {
	//当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //总页数
    private int pages;
    //总记录数
    private long total;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
}
