package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.pojo.Product;
import com.cxf.service.ProductService;

@Controller
@RequestMapping("/Detail")
public class Detail {
	
	/**
	 * 商品详情页面
	 * @param
	 * @return
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		Product product = productService.getProductByName(request.getParameter("productName"));
		mv.addObject("productName",product.getProductName());
		mv.addObject("price",product.getPrice());
		mv.addObject("imageAddress",product.getImageAddress());
		mv.addObject("info",product.getInfo());
		mv.setViewName("detail");
		return mv;
	}
	
	/**
	 * 购买商品
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/buy")
	public String buy(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return "forward:/Order/order";	
	}
	/**
	  *    转发到Login的login方法
	 * @param
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "forward:/Login/login";
	}
}
