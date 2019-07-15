package com.cxf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Index")
public class Index {
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<String> productTypeList = new ArrayList<>(); //类型列表
		productTypeList.add("手机");
		productTypeList.add("服装");
		mv.addObject("productTypeList",productTypeList);//去数据库获取产品类型数据填充
		mv.addObject("name","MUNI");
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("/test")
	public String test() {
		return "forward:/Test/test2";
	}
	@RequestMapping("test1")
	public void test1() {
		
	}
}
