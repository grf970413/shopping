package com.cxf.service;

import java.util.List;

import com.cxf.pojo.Order;

public interface OrderService {
	public int insertOrder(Order order);
	public List<Order> getOrderByUserName(String userName);
}
