package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.GapContent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.dao.ProductDao;
import com.cxf.pojo.By;
import com.cxf.pojo.MainAndBy;
import com.google.gson.Gson;

@Controller
@RequestMapping("/Index")
public class Index {
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
		//String productSort = request.getParameter("productSort");//用来根据类别查询分类
		response.setContentType("application/json");
		List<String> mainProList = productDao.getMainPro(); //主类别列表
		for(String s :mainProList) {
			System.out.println(s);
		}
		MainAndBy mainAndBy = null;
		By b = null;
		List<MainAndBy> mainAndByList = new ArrayList<MainAndBy>(); 
		for (String m:mainProList) {
			mainAndBy = new MainAndBy();
			mainAndBy.setMainPro(m);
			
			
			List<By> byList = productDao.getByPro(m);
			
			
			mainAndBy.setByList(byList);
		
				
			
			mainAndByList.add(mainAndBy);
		}
		
		mv.addObject("mainAndByList",mainAndByList);//去数据库获取产品类型数据填充
	
		mv.setViewName("index");
		return mv;
	}
	
	/**
	  *   选购
	 * @param HttpServletRequest,HttpServletResponse
	 * @return 跳转至产品列表
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/pick")
	public String pick(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String main = java.net.URLEncoder.encode(request.getParameter("main"),"utf-8");
		String by = java.net.URLEncoder.encode(request.getParameter("by"),"utf-8");
		return "redirect:/ProductList/productList?main="+main+"&by="+by;
	}
	
	@RequestMapping("/getSort") 
	public void getSort(HttpServletRequest request,HttpServletResponse response) throws IOException { //此方法废除
		String productSort = request.getParameter("productSort");//用来根据类别查询分类
		response.setContentType("application/json");
		List<MainAndBy> productTypeList = new ArrayList<>(); //类别列表
		MainAndBy typeAndSort = new MainAndBy(); //新建一个临时测试变量
		
		productTypeList.add(typeAndSort);
		
		Gson gson = new Gson();
		String s = gson.toJson(productTypeList);
		//System.out.println(s);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(s);
		printWriter.close();
	}
	
}
