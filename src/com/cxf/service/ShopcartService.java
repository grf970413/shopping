package com.cxf.service;

import java.util.List;

import com.cxf.pojo.Shopcart;

public interface ShopcartService {
	public List<Shopcart> getShopcartByUserName(String userName);//获取购物车列表
	public List<Shopcart> getShopcartByUserId(Integer userId);
}
