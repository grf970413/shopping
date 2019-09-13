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

/**
  *  注册
 * @author 啊哈
 *
 */
@Controller
@RequestMapping("/Register")
public class Register {
	
	/**
	  * 注册页面
	 * @param
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
//		if(null != request.getSession().getAttribute("page")) {
//			request.getSession().removeAttribute("page");	
//		}
//		request.getSession().setAttribute("page","/shoppingmall/Register/register");
		mv.addObject("url",request.getSession().getAttribute("url"));
		mv.setViewName("register");
		return mv;
	}
	
	/**
	  *  添加用户
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/signIn")
	public void signIn(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		PrintWriter printWriter = response.getWriter();
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		//重名验证
		String userName = request.getParameter("userName");
		if(null != userService.getUserByName(userName)) { //如果用户名已经存在
			printWriter.write("{\"res\":\"0\"}");
		} else {
			User user = (User)ctx.getBean("user"); //拿一个用户对象
			//填充数据
			user.setUserName(request.getParameter("userName"));
			System.out.println(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			user.setMobile(request.getParameter("mobile"));
			user.setAddress(request.getParameter("address"));
			//添加用户
			userService.addUser(user);
			printWriter.write("{\"res\":\"1\"}");
		}
		printWriter.close();
	}
}
