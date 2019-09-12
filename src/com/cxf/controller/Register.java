package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
  *  注册
 * @author 啊哈
 *
 */
@Controller
@RequestMapping("/Register")
public class Register {
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
	  *   用户信息填入数据库
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/signIn")
	public void signIn(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		
		//重名验证
		
		printWriter.write("{\"res\":\"1\"}");
		printWriter.close();
	}
}
