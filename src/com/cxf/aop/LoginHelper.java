package com.cxf.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class LoginHelper {
	@Pointcut("execution *(com.cxf.*.login)")
	public void pointcut() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
				.getRequestAttributes()).getRequest(); //获取当前request对象
		
	}
	@Before(value="pointcut()")
	public void before() {
		
	}
}
