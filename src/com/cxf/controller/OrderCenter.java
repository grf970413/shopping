package com.cxf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.service.OrderService;

@Controller
@RequestMapping("/OrderCenter")
public class OrderCenter {
	
	@RequestMapping("/orderCenter")
	public ModelAndView orderCenter(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		//String userName = (String)request.getSession().getAttribute("userName");
		String userName = (String)request.getSession().getAttribute("userName");
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		List<com.cxf.pojo.Order> orderList = orderService.getOrderByUserName(userName);
		mv.addObject("url",request.getSession().getAttribute("url"));
		mv.addObject("orderList",orderList);
		mv.setViewName("orderCenter");
		return mv;
	}
}
