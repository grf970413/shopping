package com.cxf.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.service.ProductService;
import com.cxf.util.MD5Util;

public class ProductServiceTest {
	
	/**
	 *
	 * @param
	 * @return
	 */
	@Ignore
	public void  getProductByName() {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
//		ProductService p = (ProductService)ctx.getBean("productServiceImpl");
//		p.getProductByName("chili");
		//System.out.println(MD5Util.StringtoMd5("1"));
	}
	
	/**
	 *
	 * @param
	 * @return
	 */
	@Test
	public void getTypeIdBySortId() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService p = (ProductService)ctx.getBean("productServiceImpl");
		Integer i = p.getTypeIdBySortId(20);
		System.out.println(i);
	}
}
