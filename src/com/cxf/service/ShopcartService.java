package com.cxf.service;

import java.util.List;
import java.util.Map;

import com.cxf.pojo.Shopcart;

public interface ShopcartService {
	public List<Shopcart> getShopcartByUserName(String userName);//获取购物车列表 //错误
	public List<Shopcart> getShopcartByUserId(Shopcart shopcart);
	public Shopcart findShopcart(Shopcart shopcart); //根据用户名和商品名称查找购物车记录
	
	public void deleteShopcart(Shopcart shopcart); //删除
	public void addShopcart(Shopcart shopcart); //添加
	public void updateShopcart(Shopcart shopcart); //更新
}
