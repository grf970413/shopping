package com.cxf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxf.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ProductList")
public class ProductList {
	
	@RequestMapping("/productList")
	public ModelAndView productList(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		//获取产品列表，用foreach去jsp遍历
		List<Product> list = new ArrayList<>();
		mv.addObject("sort",request.getParameter("sort"));
		mv.addObject("productList",list);
		mv.setViewName("productList");
		return mv;
	}
}
