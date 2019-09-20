package com.cxf.pojo;

import java.util.ArrayList;
import java.util.List;

public class SortAndType {
	private String TypeName;
	List<String> sortList = new ArrayList<String>();
	
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public List<String> getSortList() {
		return sortList;
	}
	public void setSortList(List<String> sortList) {
		this.sortList = sortList;
	}
	@Override
	public String toString() {
		return this.TypeName;
	}
}
