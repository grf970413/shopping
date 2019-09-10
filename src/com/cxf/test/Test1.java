package com.cxf.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.pojo.Shopcart;
import com.cxf.service.ShopcartService;

public class Test1 {
	
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");

		ShopcartService shopcartService = (ShopcartService)ctx.getBean("shopcartServiceImpl");
		shopcartService.getShopcartByUserName("");
		//List<com.cxf.pojo.Shopcart> shopcartList = shopcartService.getShopcartByUserId(1);
		//for (Shopcart s:shopcartList) {
		//	System.out.println(s.getProduct().getProductName());
		//}
	}
}
