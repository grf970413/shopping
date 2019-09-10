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
@RequestMapping("/PersonalCenter")
public class PersonalCenter {
	
	@RequestMapping("/personalCenter")
	public ModelAndView personalCenter(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		//String userName = (String)request.getSession().getAttribute("userName");
		String userName = "欢欢";
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		List<com.cxf.pojo.Order> orderList = orderService.getOrderByName(userName);
		for (com.cxf.pojo.Order order:orderList) {
			System.out.println(order.getId());
		}
		mv.addObject("orderList",orderList);
		mv.setViewName("personalCenter");
		return mv;
	}
	@RequestMapping("/personalInfo")
	public void personalInfo(HttpServletRequest request,HttpServletResponse response) {
		
	}
	@RequestMapping("/orderInfo")
	public void OrderInfo(HttpServletRequest request,HttpServletResponse response) {
		
	}
}
