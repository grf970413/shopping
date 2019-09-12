package com.cxf.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.dao.OrderDao;
import com.cxf.dao.ShopcartDao;
import com.cxf.pojo.Product;
import com.cxf.pojo.Shopcart;
import com.cxf.service.ShopcartService;

public class ShopcartDaoTest {
	
	@Ignore
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ShopcartService shopcartService = (ShopcartService)ctx.getBean("shopcartServiceImpl");
		ShopcartDao shopcartDao = (ShopcartDao)ctx.getBean("shopcartDaoImpl");
		
		//System.out.println(shopcartDao.getShopcartByUserId(1).size());
		System.out.println(shopcartDao.getShopcartByUserName("张三").size());
		//shopcartDao.getShopcartByUserName("");
		//List<com.cxf.pojo.Shopcart> shopcartList = shopcartService.getShopcartByUserId(1);
		//for (Shopcart s:shopcartList) {
		//	System.out.println(s.getProduct().getProductName());
		//}
//		OrderDao order = (OrderDao)ctx.getBean("orderDaoImpl");
//		order.getOrderByName("");
	}
	@Test
	public void findShopcartByUserName() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ShopcartDao shopcartDao = (ShopcartDao)ctx.getBean("shopcartDaoImpl");
//		Map map = new HashMap();
//		map.put("userName","1");
//		map.put("productName","chili");
		com.cxf.pojo.Shopcart shopcart = (com.cxf.pojo.Shopcart)ctx.getBean("shopcart");
		shopcart.setUserId(3);
		Product product = (Product)ctx.getBean("product");
		product.setId(1);
		shopcart.setProduct(product);
		//shopcartDao.findShopcartByUserName(shopcart);
		//com.cxf.pojo.Shopcart shopcart1 = shopcartDao.findShopcartByUserName(shopcart);
		//System.out.println(shopcart1.getAmount());
	}
	
}
