package com.cxf.pojo;

import java.util.ArrayList;
import java.util.List;

public class MainAndBy {
	String mainPro;//主产品
	List<By> byList = null;
	
	public String getMainPro() {
		return mainPro;
	}
	public void setMainPro(String mainPro) {
		this.mainPro = mainPro;
	}
	public List<By> getByList() {
		return byList;
	}
	public void setByList(List<By> byList) {
		this.byList = byList;
	}
}
