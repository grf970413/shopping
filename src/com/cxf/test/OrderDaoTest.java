package com.cxf.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.service.OrderService;

public class OrderDaoTest {
	
	@Test
	public void getOrderByUserName() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		List<com.cxf.pojo.Order> order = orderService.getOrderByUserName("1");
		System.out.println(order.get(0).getProduct().getId());
		System.out.println(order.get(0).getProduct().getProductName());
	}
	@Ignore
	public void insertOrder() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		//List<com.cxf.pojo.Order> order = orderService.getOrderByUserName("1");
		
	}
}
