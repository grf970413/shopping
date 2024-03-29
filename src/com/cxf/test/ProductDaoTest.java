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
	
	@Ignore
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
//		List<String> list = productDao.getMainPro();
//		for (String string : list) {
//			System.out.println(string);
//		}
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
	@Ignore
	public void getProductById() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
		//Product p = productDao.getProductById(1);
	}
	@Ignore
	public void getAllType() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
		for(String s:productDao.getAllType()) {
			System.out.println(s);
		}
		
	}
	
	/**
	 *
	 * @param
	 * @return
	 */
	@Ignore
	public void getSortIdBySortName() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
		Integer i = productDao.getSortIdBySortName("MAC");
		System.out.println(i);
	}
	
	/**
	 *
	 * @param
	 * @return
	 */
	@Test
	public void getSortNameBySortId() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
		String sortName = productDao.getSortNameBySortId(1);
		System.out.println(sortName);
	}
}
