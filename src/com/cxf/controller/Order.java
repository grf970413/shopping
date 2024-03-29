package com.cxf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.cxf.util.DateUtil;

/**
 * 确认订单
 * @author 啊哈
 *
 */
@Controller
@RequestMapping("/Order")
public class Order {
	
	/**
	 * 确认订单页面
	 * @param
	 * @return
	 */
	@RequestMapping("/order")
	public ModelAndView order(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//根据产品名称查询产品信息
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		Product product = productService.getProductByName(request.getParameter("productName"));
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		mv.addObject("imageAddress",product.getImageAddress());
		mv.addObject("price",product.getPrice());
		mv.addObject("productName",product.getProductName());
		//mv.addObject("amount",Integer.parseInt(request.getParameter("amount")));
		mv.addObject("amount",1); //test
		String userName = (String)request.getSession().getAttribute("userName"); //用户名
		List<com.cxf.pojo.Order> orderList = orderService.getOrderByUserName(userName); 
		mv.addObject("orderList",orderList);
		mv.addObject("url",request.getSession().getAttribute("url"));//先把上一页的路径填充
		request.getSession().setAttribute("url","Detail/detail?productName="+request.getParameter("productName")); //再把当前页的路径保存
		mv.setViewName("order");
		return mv;
	}
	/**
	 * 提交订单
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/commitOrder")   //此方法要加事务控制
	public void commitOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		PrintWriter printWriter = response.getWriter();
		String userName = (String)request.getSession().getAttribute("userName");//用户名
		String productName = request.getParameter("productName");//产品名称	
		int amount = Integer.parseInt(request.getParameter("amount"));//数量
		User user = userService.getUserByName(userName); //用户对象
		Product product = productService.getProductByName(productName);//产品对象
		
		//先判断金额是否足够
		if (user.getBalance()<product.getPrice()*amount) {//如果用户余额不足
			printWriter.write("{\"res\":\"2\"}"); //余额不足
		} else {
			if(product.getStock()<amount) { //库存不足
				printWriter.write("{\"res\":\"3\"}"); //余额不足
			} else { //生成订单
				com.cxf.pojo.Order order = (com.cxf.pojo.Order)ctx.getBean("order");//订单对象
				order.setOrderTime(DateUtil.getNowDateForSql()); //获取当前时间
				order.setAmount(amount);
				order.setUserId(userService.getUserIdByName(userName));
				order.setSumPrice(product.getPrice()*amount);
				order.setProduct(product);
				//把产品数量减去
				product.setStock(product.getStock()-amount);
				productService.updateProduct(product);
				//把用户的余额减去
				user.setBalance(user.getBalance()-(product.getPrice()*amount));
				userService.updateUser(user);
				orderService.insertOrder(order);
				printWriter.write("{\"res\":\"1\"}"); //成功
			}
		}		
		printWriter.close();
	}
}
