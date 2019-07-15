package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.pojo.Product;
import com.google.gson.Gson;

@Controller
@RequestMapping("/Test")
public class Test {
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public void test1(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		System.out.println(request.getParameter("productName"));
		//List<Product>
		Gson gson = new Gson();
		Product product = new Product();
		product.setId(1);
		product.setPrice(100);
		String s = gson.toJson(product);
		PrintWriter printWriter = response.getWriter();
		//String s = "{\"msg\":\"成功\"}";
		printWriter.write(s);
		printWriter.close();
	}
	
	public void test3() {
		
	}
	@RequestMapping(value="/test2")
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("productName","口红");
		mv.addObject("m","m");
		mv.setViewName("test");
		return mv;
	}
}
