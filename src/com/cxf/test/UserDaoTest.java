package com.cxf.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cxf.dao.UserDao;
import com.cxf.pojo.User;

public class UserDaoTest {
	
	/**
	 * 通过用户名获取用户对象
	 * @param
	 * @return
	 */
	@Ignore
	public void getUserByName() { //通过
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");	
		UserDao userDao = (UserDao)ctx.getBean("userDaoImpl");
		User user = userDao.getUserByName("1");
		System.out.println(user.getId());
	}
	
	/**
	 * 添加用户
	 * @param
	 * @return
	 */
	@Ignore
	public void addUser() { //通过
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");	
		UserDao userDao = (UserDao)ctx.getBean("userDaoImpl");
		User user = new User();
		user.setAddress("test1");
		user.setBalance(100);
		user.setMobile("tes1t");
		user.setPassword("1");
		user.setUserName("test1");
		userDao.addUser(user);
	}
	
	/**
	 *更新用户信息
	 * @param
	 * @return
	 */
	@Test
	public void updateUser() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");	
		UserDao userDao = (UserDao)ctx.getBean("userDaoImpl");
		User user = (User)userDao.getUserByName("grf");
		user.setBalance(0);
		userDao.updateUser(user);
	}
}
