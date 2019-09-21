package com.cxf.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxf.service.UserService;

public class UserServiceTest {
	@Test
	public void getUserIdByUserName() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		Integer	i = userService.getUserIdByUserName("1");
		System.out.println(i);
	}

}
