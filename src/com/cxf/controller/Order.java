package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.pojo.Product;
import com.cxf.pojo.User;
import com.cxf.service.OrderService;
import com.cxf.service.ProductService;
import com.cxf.service.UserService;

/**
 * @author 啊哈
 *
 */
@Controller
@RequestMapping("/Order")
public class Order {
	
	@RequestMapping("/order")
	public ModelAndView order(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//根据产品名称查询产品信息
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		Product product = productService.getProductByName(request.getParameter("productName"));
		mv.addObject("imageAddress",product.getImageAddress());
		mv.addObject("price",product.getPrice());
		mv.addObject("productName",product.getProductName());
		//mv.addObject("amount",Integer.parseInt(request.getParameter("amount")));
		mv.addObject("amount",1);
		mv.setViewName("order");
		return mv;
	}
	/**
	  *   提交订单
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/commitOrder")
	public void commitOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userServicelImpl");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		PrintWriter printWriter = response.getWriter();
		String userName = (String)request.getSession().getAttribute("userName");//用户名
		String productName = request.getParameter("productName");//产品名称
		User user = userService.getUserByName(userName);//用户对象
		Product product = productService.getProductByName(productName);//产品对象
		int amount = Integer.parseInt(request.getParameter("amount"));//数量
		//先判断金额是否足够
		if (user.getBalance()<product.getPrice()*amount) {//如果用户余额不足
			printWriter.write("{\"msg\":\"余额不足\",\"res\":\"0\"}");
		}
		//再判断库存是否足够
//		if (true) {
//			printWriter.write("{\"msg\":\"库存不足\",\"res\":\"0\"}");
//		}
		//生成订单
		com.cxf.pojo.Order order = new com.cxf.pojo.Order();
		order.setAmount(amount);
		//order.setProductId(product.getId());
		order.setUserId(user.getId());
		//还差一个当前时间
		//插入订单
		orderService.insertOrder(order);
		//更新产品信息
		product.setStock(product.getStock()-amount);//减去库存
		//更新用户信息
		user.setBalance(user.getBalance()-product.getPrice()*amount);//减去金额
		//购买成功
		if(true) { 
			printWriter.write("{\"msg\":\"购买成功\",\"res\":\"1\"}");
		}
		System.out.println("11");
	}
}
