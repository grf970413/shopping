package com.cxf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxf.dao.OrderDao;
import com.cxf.pojo.Order;
import com.cxf.service.OrderService;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

	@Resource(name="orderDaoImpl")
	private OrderDao orderDao = null;
	
	@Override
	public int insertOrder(Order order) {
		return orderDao.insertOrder(order);
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	@Override
	public List<Order> getOrderByUserName(String userName) {
		return orderDao.getOrderByUserName(userName);
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
