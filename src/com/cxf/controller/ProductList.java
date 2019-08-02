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
		
		Integer byProductId = Integer.parseInt(request.getParameter("by"));
		//获取产品列表，用foreach去jsp遍历
		
		mv.addObject("by",productService.getByProductNameById(byProductId));
		List<Product> list = productService.getProductBySortId(byProductId);
		mv.addObject("sort",request.getParameter("sort"));
		mv.addObject("productList",list);
		for (Product product : list) {
			System.out.println(product.getProductName());
			
		}
		mv.addObject("list",list);
		mv.setViewName("productList");
		return mv;
	}
}
