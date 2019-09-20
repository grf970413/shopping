package com.cxf.pojo;

import java.util.List;

/**
 * @author cxf
 * 分页类
 * @param
 * @return
 */
public class Page<T> {
	private int currentPage; //当前页
	private int pageSize; //每页显示记录数
	private int totalPage; //总页数
	private int totalCount; //总记录数
	private List<T> list; //每页显示的内容
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
