package com.cxf.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cxf.dao.AdminDao;
import com.cxf.pojo.Admin;

public class AdminDaoTest {
	
	/**
	 *
	 * @param
	 * @return
	 */
	@Test
	public void findAdminByName() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");	
		AdminDao adminDao = (AdminDao)ctx.getBean("adminDaoImpl");
		Admin a = adminDao.findAdminByName("5");
		System.out.println(a.getAdminName());
	}
	
	/**
	 *
	 * @param
	 * @return
	 */
	@Ignore
	public void getAdminIdByName() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");	
		AdminDao adminDao = (AdminDao)ctx.getBean("adminDaoImpl");
		System.out.println(adminDao.getAdminIdByName("2"));
	}
}
