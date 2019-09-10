package com.cxf.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.dao.OrderDao;
import com.cxf.dao.ShopcartDao;
import com.cxf.pojo.Shopcart;
import com.cxf.service.ShopcartService;

public class ShopcartDaoTest {
	
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ShopcartService shopcartService = (ShopcartService)ctx.getBean("shopcartServiceImpl");
		ShopcartDao shopcartDao = (ShopcartDao)ctx.getBean("shopcartDaoImpl");
		
		System.out.println(shopcartDao.getShopcartByUserId(1).size());
		System.out.println(shopcartDao.getShopcartByUserName("张三").size());
		//shopcartDao.getShopcartByUserName("");
		//List<com.cxf.pojo.Shopcart> shopcartList = shopcartService.getShopcartByUserId(1);
		//for (Shopcart s:shopcartList) {
		//	System.out.println(s.getProduct().getProductName());
		//}
//		OrderDao order = (OrderDao)ctx.getBean("orderDaoImpl");
//		order.getOrderByName("");
	}
}
