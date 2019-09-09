package com.cxf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.dao.OrderDao;
import com.cxf.pojo.Order;
import com.cxf.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	
	@Override
	public int insertOrder(Order order) {
		return orderDao.insertOrder(order);
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	@Override
	public List<Order> getOrderByName(String userName) {
		return orderDao.getOrderByName(userName);
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
