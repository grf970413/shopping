package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.GapContent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.pojo.TypeAndSort;
import com.google.gson.Gson;

@Controller
@RequestMapping("/Index")
public class Index {
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String productSort = request.getParameter("productSort");//用来根据类别查询分类
		response.setContentType("application/json");
		List<TypeAndSort> productTypeList = new ArrayList<>(); //类别列表
		TypeAndSort typeAndSort = new TypeAndSort(); //新建一个临时测试变量
		typeAndSort.setType("家电");
		typeAndSort.getSortList().add("电视机");
		typeAndSort.getSortList().add("洗衣机");
		typeAndSort.getSortList().add("空调");
		typeAndSort.getSortList().add("电风扇");
		typeAndSort.getSortList().add("加湿器");
		typeAndSort.getSortList().add("电脑");
		typeAndSort.getSortList().add("吸尘器");
		typeAndSort.getSortList().add("吸尘器");
		typeAndSort.getSortList().add("吸尘器");
		TypeAndSort typeAndSort1 = new TypeAndSort(); //新建一个临时测试变量
		typeAndSort1.setType("零食");
		typeAndSort1.getSortList().add("糖果");
		typeAndSort1.getSortList().add("饼干");
		typeAndSort1.getSortList().add("果冻");
		typeAndSort1.getSortList().add("冰淇淋");
		productTypeList.add(typeAndSort);
		productTypeList.add(typeAndSort1);
		mv.addObject("productTypeList",productTypeList);//去数据库获取产品类型数据填充
	
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
		String sort = java.net.URLEncoder.encode(request.getParameter("sort"),"utf-8");
		return "redirect:/ProductList/productList?sort="+sort;
	}
	
	@RequestMapping("/getSort") 
	public void getSort(HttpServletRequest request,HttpServletResponse response) throws IOException { //此方法废除
		String productSort = request.getParameter("productSort");//用来根据类别查询分类
		response.setContentType("application/json");
		List<TypeAndSort> productTypeList = new ArrayList<>(); //类别列表
		TypeAndSort typeAndSort = new TypeAndSort(); //新建一个临时测试变量
		typeAndSort.setType("家电");
		typeAndSort.getSortList().add("电视机");
		typeAndSort.getSortList().add("洗衣机");
		typeAndSort.getSortList().add("空调");
		typeAndSort.getSortList().add("电风扇");
		typeAndSort.getSortList().add("加湿器");
		typeAndSort.getSortList().add("电脑");
		typeAndSort.getSortList().add("吸尘器");
		TypeAndSort typeAndSort1 = new TypeAndSort(); //新建一个临时测试变量
		typeAndSort1.setType("零食");
		typeAndSort1.getSortList().add("糖果");
		typeAndSort1.getSortList().add("饼干");
		typeAndSort1.getSortList().add("果冻");
		productTypeList.add(typeAndSort);
		productTypeList.add(typeAndSort1);
		Gson gson = new Gson();
		String s = gson.toJson(productTypeList);
		//System.out.println(s);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(s);
		printWriter.close();
	}
	
}
