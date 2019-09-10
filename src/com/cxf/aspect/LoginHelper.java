package com.cxf.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class LoginHelper {
	
	@Pointcut("execution(* com.cxf.controller.Login.login(..))")
	public void pointcut() {
	}
	@Before(value="pointcut()")
	public void before() {
		
	}
}
