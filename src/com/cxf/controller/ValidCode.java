package com.cxf.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 生成验证码
 * @author 啊哈
 *
 */
@Controller
@RequestMapping("/ValidCode")
public class ValidCode {
	
	@RequestMapping("/validCode")
	public void validCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ServletOutputStream os = response.getOutputStream();
		String code = com.cxf.util.ValidCode.getCode( os );
		HttpSession session = request.getSession();
		session.setAttribute( "code",code );
	}
}
