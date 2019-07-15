package com.cxf.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
  *   类型及分类
 * @param
 * @return
 */
public class TypeAndSort {
	private String type;
	private List<String> sortList = new ArrayList<>();
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getSortList() {
		return sortList;
	}
	public void setSortList(List<String> sortList) {
		this.sortList = sortList;
	}
}
