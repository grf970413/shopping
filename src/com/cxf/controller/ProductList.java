package com.cxf.controller;

import java.util.ArrayList;
import java.util.List;
import com.cxf.service.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxf.dao.ProductDao;
import com.cxf.pojo.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ProductList")
public class ProductList {
	
	@RequestMapping("/productList")
	public ModelAndView productList(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		
		Integer sortId = Integer.parseInt(request.getParameter("sortId"));
		//获取产品列表，用foreach去jsp遍历
		
		mv.addObject("sortName",productService.getByProductNameById(sortId)); //分类名称
		List<Product> list = productService.getProductBySortId(sortId); //产品列表
		mv.addObject("sort",request.getParameter("sort"));
		mv.addObject("productList",list);
		for (Product product : list) {
			System.out.println(product.getProductName());
			
		}
		//mv.addObject("list",list);
	
		
		if(null != request.getSession().getAttribute("userName")) { //如果已经登录，要把用户名填进去
			String userName = (String)request.getSession().getAttribute("userName");
			mv.addObject("userName",userName);
		}
		//保存当前页面的路径
		request.getSession().setAttribute("ProductList","/shoppingmall/ProductList/productList?typeId="
				+request.getParameter("typeId")+"&sortId="+request.getParameter("sortId"));
		request.getSession().setAttribute("url","ProductList/productList?typeId="
				+request.getParameter("typeId")+"&sortId="+request.getParameter("sortId"));
		mv.setViewName("productList");
		return mv;
	}
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response) {
		
	}
	@RequestMapping("/shopcart")
	public String shopcart(HttpServletRequest request,HttpServletResponse response) {
		return "forward:/Shopcart/shopcart";
	}
}
