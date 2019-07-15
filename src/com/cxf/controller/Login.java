package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 啊哈
  *   登录
 */

@Controller
@RequestMapping("/Login")
public class Login {
	

	/**
	  *   登录方法
	 * @param
	 * @return
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String userName = request.getParameter("username");//获取姓名
		String password = request.getParameter("password");//获取密码
		//boolean res = userService.validate(userName,password);
		PrintWriter printWriter = response.getWriter();
		System.out.println(userName);
		printWriter.write("{\"msg\":\"success\"}");
	}
}
