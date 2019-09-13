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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cxf.pojo.Product;
import com.cxf.pojo.User;
import com.cxf.service.OrderService;
import com.cxf.service.ProductService;
import com.cxf.service.ShopcartService;
import com.cxf.service.UserService;
import com.cxf.util.DateUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/Shopcart")
public class Shopcart {
	
	/**
	 * 购物车页面
	 * @param
	 * @return
	 */
	@RequestMapping("/shopcart")
	public ModelAndView shopcart(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
			//去数据库查询出购物车表的信息，填充
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
			String userName = (String)request.getSession().getAttribute("userName"); //用户名
			UserService userService = (UserService)ctx.getBean("userServiceImpl");
			ShopcartService shopcartService = (ShopcartService)ctx.getBean("shopcartServiceImpl");
			mv.addObject("prePage",request.getSession().getAttribute("url"));
			com.cxf.pojo.Shopcart shopcart = (com.cxf.pojo.Shopcart)ctx.getBean("shopcart");
			shopcart.setUserId(userService.getUserIdByName(userName));
			mv.addObject("shopcartList",shopcartService.getShopcartByUserId(shopcart));//购物车列表	
			mv.setViewName("shopcart");
		return mv;
	}
	/**
	 * 清空购物车
	 * @param
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/settleAccount")   //此方法要加事务控制
	public void settleAccount(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		boolean res = true;
		Gson gson = new Gson();
		PrintWriter printWriter = response.getWriter();
		OrderService orderService = (OrderService)ctx.getBean("orderServiceImpl");
		ShopcartService shopcartService = (ShopcartService)ctx.getBean("shopcartServiceImpl");
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		String userName = (String)request.getSession().getAttribute("userName");//当前用户名
		User user = userService.getUserByName(userName); 
		List<com.cxf.pojo.Shopcart> shopcartList = gson.
				fromJson(request.getParameter("productList"),
						new TypeToken<List<com.cxf.pojo.Shopcart>>(){}.getType());//选中的购物车列表
		
		if(user.getBalance()<Float.parseFloat(request.getParameter("sumPrice"))) { //如果用户余额不足
			printWriter.write("{\"res\":\"0\"}"); //余额不足
		} else {
			//循环遍历产品列表
			for (com.cxf.pojo.Shopcart shopcart:shopcartList) {
				//进行数据库操作
				Product product = productService.getProductByName(shopcart.getProduct().getProductName());  //bug
				shopcart.setUserId(userService.getUserIdByName(userName));
				shopcart.setProduct(product);
				if(product.getStock()<shopcart.getAmount()) { //如果库存不足
					res = false;
					printWriter.write("{\"res\":\"2\"}"); //库存不足
					break;
				} else { //该产品库存充足
					com.cxf.pojo.Order order = (com.cxf.pojo.Order)ctx.getBean("order");//创建一个订单对象
					order.setSumPrice(product.getPrice()*shopcart.getAmount());//每条订单的金额  
					order.setUserId(userService.getUserIdByName((String)request.getSession().getAttribute("userName")));
					order.setProduct(product);
					order.setAmount(shopcart.getAmount());//数量
					//减去产品数量
					product.setStock(product.getStock()-shopcart.getAmount());
					productService.updateProduct(product);
					//减去用户余额
					user.setBalance(user.getBalance()-product.getPrice()*shopcart.getAmount());
					userService.updateUser(user);
					order.setOrderTime(DateUtil.getNowDateForSql());//当前时间
					//插入订单
					orderService.insertOrder(order);
					//删除对应的购物车记录
					shopcartService.deleteShopcart(shopcart);
				}
				
			}
		}
		if(true==res) {
			printWriter.write("{\"res\":\"1\"}"); //成功
		}
	
		printWriter.close();
	}
	/**
	 * 删除一条记录
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/deleteShopcart")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter printWriter = response.getWriter();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		ShopcartService shopcartService = (ShopcartService)ctx.getBean("shopcartServiceImpl");
		com.cxf.pojo.Shopcart shopcart = (com.cxf.pojo.Shopcart)ctx.getBean("shopcart");
		String productName = request.getParameter("productName");
		String userName = (String)request.getSession().getAttribute("userName");
		shopcart.setUserId(userService.getUserIdByName(userName));
		shopcart.setProduct(productService.getProductByName(productName)); //放置产品对象
		shopcartService.deleteShopcart(shopcart);
		printWriter.write("{\"res\":\"1\"}");
		printWriter.close();
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
	@RequestMapping("/addShopcart")
	public void addShopcart(HttpServletRequest request,HttpServletResponse response) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
	}
}
