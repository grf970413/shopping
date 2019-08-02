package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		mv.addObject("productName",request.getParameter("productName"));
		mv.addObject("price",Float.parseFloat(request.getParameter("price")));
		mv.addObject("imageAddress",request.getParameter("imageAddress"));
		mv.addObject("info","Mac口红");
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
	public void buy(HttpServletRequest request,HttpServletResponse response) throws IOException {
		boolean res = true;//用来判断是否购买成功的标准
		//进行数据库操作
		String productName = request.getParameter("productName");
		float price = Float.parseFloat(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		System.out.println(productName+price+amount);
		//返回购买结果
		PrintWriter printWriter = response.getWriter();
		if(true==res) {
			printWriter.write("{\"res\":\"1\"}");
		} else {
			printWriter.write("{\"res\":\"0\"}");
		}
	}
}
