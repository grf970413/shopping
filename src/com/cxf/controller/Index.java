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
import com.cxf.pojo.Sort;
import com.cxf.pojo.TypeAndSort;
import com.cxf.service.ProductService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/Index")
public class Index {
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		//如果用户已经登录，那么要对页面的用户名称标签进行填充 
		
		
	
		//String productSort = request.getParameter("productSort");//用来根据类别查询分类
		response.setContentType("application/json");
		List<String> typeList = productService.getType(); //主类别列表
		for(String s :typeList) {
			System.out.println(s);
		}
		//MainAndBy mainAndBy = null;
		TypeAndSort tas = null;
		//By b = null;
		Sort sort = null; 
		List<TypeAndSort> typeAndSortList = new ArrayList<TypeAndSort>(); 
		for (String t:typeList) {
			tas = new TypeAndSort();
			tas.setTypeId(t);
			List<Sort> sortList = productService.getSort(t);
			tas.setSortList(sortList);
			typeAndSortList.add(tas);
		}
		
		mv.addObject("typeAndSortList",typeAndSortList);//去数据库获取产品类型数据填充
		if(null != (String)request.getSession().getAttribute("userName")) {
			mv.addObject("userName",request.getSession().getAttribute("userName"));
		} else {
			
		}
		//System.out.println((String)request.getSession().getAttribute("userName"));
		request.getSession().setAttribute("url","Index/index"); //保存当前页面的路径
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
		String typeId = java.net.URLEncoder.encode(request.getParameter("typeId"),"utf-8");
		String sortId = java.net.URLEncoder.encode(request.getParameter("sortId"),"utf-8");
		return "redirect:/ProductList/productList?typeId="+typeId+"&sortId="+sortId;
	}
	
	@RequestMapping("/getSort") 
	public void getSort(HttpServletRequest request,HttpServletResponse response) throws IOException { //此方法废除
		String productSort = request.getParameter("productSort");//用来根据类别查询分类
		response.setContentType("application/json");
		List<TypeAndSort> productTypeList = new ArrayList<>(); //类别列表
		TypeAndSort typeAndSort = new TypeAndSort(); //新建一个临时测试变量
		
		productTypeList.add(typeAndSort);
		
		Gson gson = new Gson();
		String s = gson.toJson(productTypeList);
		//System.out.println(s);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(s);
		printWriter.close();
	}
	/**
	 *
	 * @param
	 * @return
	 */
	@RequestMapping("/shopcart")
	public void shopcart(HttpServletRequest request,HttpServletResponse response) {
		
	}
}
