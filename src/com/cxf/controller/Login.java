package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		mv.setViewName("login");
		return mv;
	}
	
	/**
	 * 身份验证
	 * @param
	 * @return
	 */
	@RequestMapping("/validate")
	public String validate(HttpServletRequest request,HttpServletResponse response) {
		boolean res = false;
		String url = null;
		String userName = request.getParameter("userName"); 
		if (true==res) {
			request.getSession().setAttribute("userName",userName);
			url = request.getParameter("page");
		} else {
			
		}
		return "redirect:" + url;
	}
	/**
	 * 验证用户是否登录
	 * @param
	 * @return
	 */
	@RequestMapping("/validateLogin")
	public boolean validateLogin(HttpServletRequest request,HttpServletResponse response) {
		boolean res = false;
		//request.getSession().setAttribute("userName","张三");
		if(null!=request.getSession().getAttribute("userName")) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}
}
