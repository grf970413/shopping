package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 啊哈
 * 注册界面
 */
@Controller
@RequestMapping("/Sign")
public class Sign {
	/**
	 * 注册方法
	 * @param
	 * @return
	 */
	@RequestMapping("/sign")
	public void sign(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String tel = request.getParameter("tel");
		
		PrintWriter printWriter = response.getWriter();
		printWriter.write("注册成功！！！");
	}
}
