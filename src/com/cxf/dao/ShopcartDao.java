package com.cxf.dao;

import java.util.List;

import com.cxf.pojo.Order;
import com.cxf.pojo.Shopcart;

public interface ShopcartDao {
	public List<Shopcart> getShopcartByUserId(Integer userId);
	public List<Shopcart> getShopcartByUserName(String userName);
	public Shopcart getShopcartById(Integer id); 
}
