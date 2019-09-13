package com.cxf.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.service.ProductService;
import com.cxf.util.MD5Util;

public class ProductServiceTest {
	
	@Test
	public void  getProductByName() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
//		ProductService p = (ProductService)ctx.getBean("productServiceImpl");
//		p.getProductByName("chili");
		//System.out.println(MD5Util.StringtoMd5("1"));
	}
}
