package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.pojo.Product;
import com.cxf.service.ProductService;
import com.cxf.service.ShopcartService;
import com.cxf.service.UserService;

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
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		Product product = productService.getProductByName(request.getParameter("productName")); //获得选中的产品信息
		mv.addObject("productName",product.getProductName());
		mv.addObject("price",product.getPrice());
		mv.addObject("imageAddress",product.getImageAddress());
		mv.addObject("info",product.getInfo());
		request.getSession().setAttribute("url","/Detail/detail?productName="+request.getParameter("productName"));
		
		mv.addObject("prePage",request.getSession().getAttribute("ProductList")); //上一页是产品列表页
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
	public String buy(HttpServletRequest request,HttpServletResponse response) throws IOException {
		return "redirect:/Order/order?productName="+request.getParameter("productName");	
	}
	/**
	  *    转发到Login的login方法
	 * @param
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
//	@RequestMapping("/login")
//	public String login1(HttpServletRequest request,HttpServletResponse response) throws Exception {
//		return "forward:/Login/login";
//	}
	/**
	 * 加入购物车
	 * @param
	 * @return
	 */
	@RequestMapping("/addShopcart")
	public void addShopcart(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ShopcartService shopcartService = (ShopcartService)ctx.getBean("shopcartServiceImpl");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		String userName = (String)request.getSession().getAttribute("userName"); //用户名
		String productName = request.getParameter("productName"); //产品名称
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		Product product = productService.getProductByName(productName);
		com.cxf.pojo.Shopcart shopcart = (com.cxf.pojo.Shopcart)ctx.getBean("shopcart");
		int amount = Integer.parseInt((String)request.getParameter("amount")); //数量
		Map map = new HashMap();
		map.put("userName",userName);
		map.put("productName",productName);
		if(null != shopcartService.findShopcartByUserName(map)) { //如果已经添加了该商品，则把数量加上
			//执行更新操作
			//shopcartService.updateShopcart(shopcart);
		} else { //否则新增记录
			//设置Shopcart的值
			shopcart.setUserId(userService.getUserIdByName(userName));
			shopcart.setAmount(amount);
			//shopcart.setPrice(price);
			
			shopcart.setProduct(product);
			//shopcart.
			//执行添加操作
			//shopcartService.addShopcart(shopcart); 
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.write("{\"res\":\"1\"}");
		printWriter.close();
	}
}
