package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.dao.ProductDao;
import com.cxf.pojo.SortAndType;
import com.cxf.pojo.TypeAndSort;
import com.cxf.service.ProductService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/CategoryManage")
public class CategoryManage {
	
	@RequestMapping("/category")
	public ModelAndView categoryManage(HttpServletRequest request,HttpServletResponse response) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		Gson gson = new Gson();
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		ModelAndView mv = new ModelAndView();
		//去数据库读取产品分类列表
		List<SortAndType> typeAndSortList = new ArrayList<>();//产品类型及分类列表
		List<String> typeList = productService.getAllTypeName();//
		for (String typeName:typeList) {
			//TypeAndSort t = new TypeAndSort();
			SortAndType t = new SortAndType();
			t.setTypeName(typeName);
			
			ProductDao productDao = (ProductDao)ctx.getBean("productDaoImpl");
			Integer typeId = productDao.getTypeIdByTypeName(typeName);
			System.out.println("typeId="+typeId);
			
			t.setSortList(productDao.getSortListByTypeId(typeId));  //一个是String类型一个是Sort类型
			for (String s:productDao.getSortListByTypeId(typeId)) {
				System.out.println(s);
			}
			typeAndSortList.add(t);
		}
		String s = gson.toJson(typeAndSortList);
		System.out.println(s);
		mv.addObject("typeAndSortList",s);
		mv.setViewName("admin/category");
		return mv;
	}
	@RequestMapping("/category-add")
	public ModelAndView categoryAdd(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/category-add");
		return mv;
	}
	
	/**
	 * 添加种类
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/addType")
	public void addType(HttpServletRequest request,HttpServletResponse response) throws IOException {		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		PrintWriter printWriter = response.getWriter();
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		String typeName = request.getParameter("typeName");
		System.out.println(typeName);
		try {
			productService.addType(typeName);
			printWriter.write("{\"res\":\"1\"}");
		} catch (Exception e) {
			printWriter.write("{\"res\":\"0\"}");
			//e.printStackTrace();
		}
		printWriter.close();
	}
	
	/**
	 * 添加分类
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/addSort")
	public void addSort(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		PrintWriter printWriter = response.getWriter();
		String typeName = request.getParameter("typeName");
		System.out.println(typeName);
		String sortName = request.getParameter("sortName");
		Integer typeId = productService.getTypeIdByTypeName(typeName);
		Map map = new HashMap<Object,Object>();
		System.out.println(typeId);
		System.out.println(sortName);
		map.put("typeId",typeId);
		map.put("sortName",sortName);
		try {
			productService.addSort(map);
			printWriter.write("{\"res\":\"1\"}");
		} catch (Exception e) {
			printWriter.write("{\"res\":\"0\"}");
			//e.printStackTrace();
		}
		printWriter.close();
	}
	/**
	 * 删除一级分类和二级分类
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/delete") //只做了删除二级分类
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		if (null!=request.getParameter("sortName")) { //删除二级分类
			System.out.println(request.getParameter("sortName"));
			productService.deleteSort(request.getParameter("sortName"));
			printWriter.write("{\"res\":\"1\"}");
		} else { //删除一级分类
			String typeName = request.getParameter("typeName");
			productService.deleteType(typeName);
			printWriter.write("{\"res\":\"1\"}");
		}
		printWriter.close();
	}
	/**
	 * 更新分类名称
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		if (null!=request.getParameter("sortName")) { //修改二级分类
			System.out.println(request.getParameter("sortName"));
			System.out.println(request.getParameter("newName"));
			String sortName = request.getParameter("sortName");
			String newName = request.getParameter("newName");
			Map map = new HashMap<String, String>();
			map.put("sortName",sortName);
			map.put("newName",newName);
			
			//map.put("sortId",productService.getSortIdBySortName(sortName));
			
			
			try {
				productService.renameSort(map);
				printWriter.write("{\"res\":\"1\"}");
			} catch (Exception e) {
				printWriter.write("{\"res\":\"0\"}");
				e.printStackTrace();
			}
			
			
			
			
			
		} else { //修改一级分类
			//System.out.println(request.getParameter("typeName"));
			//System.out.println(request.getParameter("newName"));
			Map map = new HashMap<Object,Object>();
			map.put("typeName",request.getParameter("typeName"));
			System.out.println(request.getParameter("typeName"));
			map.put("newName",request.getParameter("newName"));
			System.out.println(request.getParameter("newName"));
			map.put("typeId",productService.getTypeIdByTypeName(request.getParameter("typeName")));
			try {
				productService.renameType(map);
				printWriter.write("{\"res\":\"1\"}");
			} catch (Exception e) {
				printWriter.write("{\"res\":\"0\"}");
			}
		}
		printWriter.close();
	}
	
}
