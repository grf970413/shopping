package com.cxf.dao;

import java.util.List;

import com.cxf.pojo.Order;

public interface OrderDao {
	public int insertOrder(Order order);//插入订单
	public List<Order> getOrderByName(String userName);
}
