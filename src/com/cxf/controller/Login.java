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
		mv.addObject("page",request.getParameter("page"));
		mv.addObject("productName",request.getParameter("producName"));
		mv.setViewName("login");
		return mv;
	}
	
	/**
	  *   身份验证
	 * @param
	 * @return
	 */
	@RequestMapping("/validate")
	public String validate(HttpServletRequest request,HttpServletResponse response) {
		boolean res = true;
		String url = null;
		String userName = request.getParameter("userName"); 
		if (true==res) {//如果通过验证，则跳转回原来的页面
			request.getSession().setAttribute("userName",userName);
			//if(request.getParameter("page").equals("detail")) { 
				url = "/Detail/detail?productName="+request.getParameter("productName"); 
				System.out.println(request.getParameter("productName"));
			//}
		} else { //未通过验证，则跳转回原来页面的login方法
			if(request.getParameter("page").equals("detail")) {
				url = "/Detail/login?page="+request.getParameter("page")+"&productName="+request.getParameter("productName");
			}
		}
		return "redirect:" + url;
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
	@RequestMapping("/withdraw")
	public void withdraw(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("userName");
		PrintWriter printWriter = response.getWriter();
		printWriter.write("{\"res\":\"1\"}");
		
	}
}
