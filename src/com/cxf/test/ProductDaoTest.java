package com.cxf.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cxf.dao.*;
import com.cxf.pojo.*;

public class ProductDaoTest {
	
	@Test
	public void testGetProduct() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
		//System.out.println(productDao.getProductById(1).getProductName());
		//System.out.println(productDao.getProductByName("fresh").getPrice());
		Product product = productDao.getProductById(1);
		product.setPrice(0);
		
		System.out.println(productDao.updateProduct(product));
	}
	@Ignore
	public void testGetMainPro() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
		List<String> list = productDao.getMainPro();
		for (String string : list) {
			System.out.println(string);
		}
	}
	@Ignore
	public void testGetByPro() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
//		//List<String> list = productDao.getByPro("美妆");
//		for (String string : list) {
//			System.out.println(string);
//		}
	}
	@Ignore
	public void test() {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		//Aop aop = (Aop)ctx.getBean("aop");
		
	}
}
