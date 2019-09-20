package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxf.pojo.Page;
import com.cxf.pojo.Product;
import com.cxf.service.ProductService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/Paging")
public class Paging {
	
	@RequestMapping(value="/getProductPagingData")
	public void getProductPageData(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		Gson gson = new Gson();
		String sortName = request.getParameter("sortName");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		int totalCount = productService.getTotalBySortName(sortName);//获取总记录数
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));//当前页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); //页面大小
		Page<Product> page = (Page)ctx.getBean("page");
		Map map = new HashMap();
		map.put("sortName",request.getParameter("sortName"));
		map.put("start",currentPage*pageSize-1); 
		map.put("offset",pageSize);
		List<Product> list = productService.getProductBypaging(map);
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage);
		page.setTotalCount(totalCount);
		page.setList(list);
//		if(productService.getProductBypaging(map).size()==0) {
//			System.out.println("为空");
//		} else {
//			
//			List<Product> list = productService.getProductBypaging(map);
//			for (Product product:list) {
//				System.out.println(product.getProductName());
//			}
//		}
		String s = gson.toJson(page);
		printWriter.write(s);
		printWriter.close();
	}
}
