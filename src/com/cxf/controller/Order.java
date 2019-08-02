package com.cxf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 啊哈
 *
 */
@Controller
@RequestMapping("/Order")
public class Order {
	
	@RequestMapping("/order")
	public ModelAndView order(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("order");
		return mv;
	}
}
