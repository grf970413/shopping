package com.cxf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cxf.exception.NoLoginException;

/**
 * 异常处理控制器
 * @author 啊哈
 *
 */
@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value=NoLoginException.class)
	public ModelAndView a(Exception e) {
		System.out.println("111");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
}
