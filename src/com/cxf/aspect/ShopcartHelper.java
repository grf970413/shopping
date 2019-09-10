package com.cxf.aspect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cxf.exception.NoLoginException;

@Component
@Aspect
public class ShopcartHelper {
	
	@Pointcut("execution(* com.cxf.controller.*.shopcart(..))")
	public void pointcut() throws Exception {	
	}
	
	@Before("pointcut()")
	public void before(JoinPoint joinPoint) throws IOException { //验证是否登录
		System.out.println("before()执行");
		Object[] obj = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)obj[0];
		HttpServletResponse response = (HttpServletResponse)obj[1];
		if(request==null) {
			System.out.println("null");
		} else {
			System.out.println("not null");
		}
		if(null == request.getSession().getAttribute("userName")) {
			try {
				//request.getRequestDispatcher("/Login/login").forward(request, response);
				System.out.println("未登录，重定向到Login");
				response.sendRedirect("/shoppingmall/Login/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("已登录，跳转到购物车页面");
			//response.sendRedirect("/shoppingmall/Shopcart/shopcart");
		}		
	}
	@After("pointcut()")
	public void after(JoinPoint joinPoint) {
		Object[] obj = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest)obj[0];
		HttpServletResponse response = (HttpServletResponse)obj[1];
//		try {
//			request.getRequestDispatcher("/Shopcart/shopcart").forward(request, response);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
}
