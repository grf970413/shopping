package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.pojo.User;
import com.cxf.service.UserService;
import com.cxf.util.MD5Util;

/**
 * @author 啊哈
 * 登录
 */

@Controller
@RequestMapping("/Login")
public class Login {
	
	/**
	 * 登录方法
	 * @param
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("page",request.getParameter("page"));
		mv.addObject("productName",request.getParameter("productName"));
		mv.setViewName("login");
		return mv;
	}
	
	/**
	  *   身份验证
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/validate")
	public void validate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		PrintWriter printWriter = response.getWriter();
		boolean res = true;
		String url = null;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password"); 
		String rigthValidCode = (String)request.getSession().getAttribute("validCode"); //正确的验证码
//		String userName = request.getParameter("userName"); 
		User user = userService.getUserByName(userName); //user对象
		//先判断验证码是否正确
		System.out.println(rigthValidCode);
		if(request.getParameter("validCode").equals(rigthValidCode)) {
			
			if (null != user) {//判断用户是否存在
				if(MD5Util.toMd5(password).equals(user.getPassword())) { //如果密码正确
					request.getSession().setAttribute("userName",userName); //把用户名写入session
					printWriter.write("{\"res\":\"1\"}"); //正确
				} else {
					printWriter.write("{\"res\":\"2\"}"); //密码错误
				}
			} else { 
				printWriter.write("{\"res\":\"0\"}"); //用户不存在
			}
		} else {
			printWriter.write("{\"res\":\"3\"}"); //验证码错误
		} 	
	}
	/**
	  *   验证用户是否登录
	 * @param
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/validateLogin")
	public void validateLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		boolean res = false;
		//request.getSession().setAttribute("userName","张三");
		if(null!=request.getSession().getAttribute("userName")) {
			res = true;
		} else {
			res = false;
		}
		PrintWriter printWriter = response.getWriter();
		if(true==res) {
			printWriter.write("{\"res\":\"1\",\"userName\":\"1\"}");
		} else {
			printWriter.write("{\"res\":\"0\",\"userName\":\"1\"}");
		}
	}
	/**
	 *	注销登录
	 * @param
	 * @return
	 */
	@RequestMapping("/logout")
	public void withdraw(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("userName");
		PrintWriter printWriter = response.getWriter();
		printWriter.write("{\"res\":\"1\"}");
		
	}
}
