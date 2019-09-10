package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.exception.NoLoginException;
import com.cxf.pojo.Product;
import com.cxf.service.OrderService;
import com.cxf.service.ProductService;
import com.cxf.service.ShopcartService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/Shopcart")
@ControllerAdvice
public class Shopcart {
	
	/**
	 * 购物车页面
	 * @param
	 * @return
	 */
	@ExceptionHandler(NoLoginException.class)
	@RequestMapping("/shopcart")
	public ModelAndView shopcart(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
			//去数据库查询出购物车表的信息，填充
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
			//String userName = (String)request.getSession().getAttribute("userName"); //用户名
			String userName = "张三";
			ShopcartService shopcartService = (ShopcartService)ctx.getBean("shopcartServiceImpl");
			mv.addObject("shopcartList",shopcartService.getShopcartByUserName(userName));//购物车列表	
			mv.setViewName("shopcart");
		return mv;
	}
	/**
	 * 结算
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/settleAccount")
	public void settleAccount(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		Gson gson = new Gson();
		String userName = (String)request.getParameter("userName");//当前用户名
		Integer userId = null;
		List<com.cxf.pojo.Shopcart> shopcartList = gson.
				fromJson(request.getParameter("productList"),
						new TypeToken<List<com.cxf.pojo.Shopcart>>(){}.getType());//选中的购物车列表
		//循环遍历产品列表
		for (com.cxf.pojo.Shopcart shopcart:shopcartList) {
			//进行数据库操作
			//Product product = productService.getProductByName();
			Product product = (Product)ctx.getBean("product");
			//还得通过shocart里面的product对象的productName去查询整个产品对象然后替换掉原来的
			//System.out.println(shopcart.getProduct().getProductName());
			com.cxf.pojo.Order order = (com.cxf.pojo.Order)ctx.getBean("order");//创建一个订单对象
			order.setSumPrice(product.getPrice()*shopcart.getAmount());//总金额
			order.setUserId(1);
			//order.setProductId(product.getId());
			order.setAmount(shopcart.getAmount());//数量
			java.util.Date nowDate = new Date(System.currentTimeMillis());
			java.sql.Date orderTime = new Date(nowDate.getTime());
			order.setOrderTime(orderTime);//当前时间
			//插入订单
			orderService.insertOrder(order);
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.write("{\"res\":\"1\"}");
		printWriter.close();
	}
	/**
	 * 删除一条记录
	 * @param
	 * @return
	 */
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request,HttpServletResponse response) {
		String productName = request.getParameter("productName");
		String userName = (String)request.getAttribute("userName");
		
	}
	/**
	 * 更新购物车信息
	 * @param
	 * @return
	 */
	@RequestMapping("/update")
	public void update(HttpServletRequest request,HttpServletResponse response) { //其实就是修改数量而已
		
	}
	/**
	 * 加入购物车
	 * @param
	 * @return
	 */
	@RequestMapping("/insert")
	public void insert(HttpServletRequest request,HttpServletResponse response) {
		
	}
}
