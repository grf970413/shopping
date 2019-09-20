package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.pojo.User;
import com.cxf.service.UserService;

@Controller
@RequestMapping("/UserManage")
public class UserManage {
	
	/**
	 * 用户列表页面
	 * @param
	 * @return
	 */
	@RequestMapping("/user-list")
	public ModelAndView userList(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		List<User> userList = userService.getAllUser();
		mv.addObject("userList",userList);
		mv.setViewName("admin/user-list");
		return mv;
	}
	/**
	 * 添加用户信息页面
	 * @param
	 * @return
	 */
	@RequestMapping("/user-add")
	public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
	
		mv.setViewName("admin/user-add");
		return mv;
	}
	/**
	 * 更新用户信息页面
	 * @param
	 * @return
	 */
	@RequestMapping("/user-update")
	public ModelAndView updateUser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		//填充数据
		//mv.addObject("realName", request.getParameter("realName"));
		mv.addObject("userName",request.getParameter("userName"));
		mv.addObject("balance",request.getParameter("balance"));
		mv.addObject("address",request.getParameter("address"));
		mv.addObject("mobile",request.getParameter("mobile"));
		mv.addObject("password",request.getParameter("password"));
		mv.setViewName("admin/user-update");
		return mv;
	}
	
	/**
	 * 删除用户
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/delete")
	public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		PrintWriter printWriter = response.getWriter();
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		//String userName = request.getParameter("userName");
		//Integer userId = userService.getUserIdByUserName(userName);
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		//User user = userService.getUserByName(userName);
		User user = userService.findUserById(userId);
		userService.deleteUser(user);
		//userService.findUserById(userId);
		printWriter.write("{\"res\":\"1\"}");
		printWriter.close();
	}
	
	/**
	 * 添加用户
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		PrintWriter printWriter = response.getWriter();
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		//String realName = request.getParameter("realName");
		//userService.
		if(null != userService.getUserByName(userName)) {
			printWriter.write("{\"res\":\"0\"}");
		} else {
			User user = ctx.getBean("user",User.class);
			user.setAddress(address);
			user.setMobile(mobile);
			user.setPassword(password);
			user.setUserName(userName);
		
			userService.addUser(user);
			printWriter.write("{\"res\":\"1\"}");
		}
		printWriter.close();
	}
	
	@RequestMapping("/update")
	public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		PrintWriter printWriter = response.getWriter();
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		//String realName = request.getParameter("realName");
		float balance = Float.parseFloat(request.getParameter("balance"));
		Integer userId = userService.getUserIdByUserName(userName);
		User user = userService.findUserById(userId);
		
		
		
		
		user.setAddress(address);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setUserName(userName);
	
		user.setBalance(balance);
		userService.updateUser(user);
		printWriter.write("{\"res\":\"1\"}");
		printWriter.close();
	}
}
