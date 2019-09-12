package com.cxf.dao;

import java.util.List;
import java.util.Map;

import com.cxf.pojo.Order;
import com.cxf.pojo.Shopcart;

public interface ShopcartDao {
	public List<Shopcart> getShopcartByUserId(Shopcart shopcart);
	public List<Shopcart> getShopcartByUserName(String userName);
	public Shopcart getShopcartById(Integer id); 
	//public Shopcart findShopcartByUserName(Map<Object,Object> map); //根据用户名和商品名称查找购物车记录
	public Shopcart findShopcart(Shopcart shopcart); //根据用户名和商品名称查找购物车记录
	public void deteleShopcart(Shopcart shopcart); //删除
	public void addShopcart(Shopcart shopcart); //添加
	public void updateShopcart(Shopcart shopcart); //更新
}
