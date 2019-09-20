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

import com.cxf.exception.AdminIsStopException;
import com.cxf.exception.AdminNoExistException;
import com.cxf.exception.PasswordErrorException;
import com.cxf.pojo.Admin;
import com.cxf.service.AdminService;
import com.cxf.util.MD5Util;

/**
 * @author Administrator
 * 后台管理导航页
 * @param
 * @return
 */
@Controller
@RequestMapping("/AdminIndex")
public class AdminIndex {
	
	/**
	 * 管理员index页面
	 * @param
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		AdminService adminService = ctx.getBean("adminServiceImpl",AdminService.class);
		ModelAndView mv = new ModelAndView();
		
		Admin admin = adminService.getAdminById(Integer.parseInt((String)request.getSession().getAttribute("adminId")));
		mv.addObject("adminName",admin.getAdminName());
		mv.setViewName("admin/index");
		return mv;
	}
	
	/**
	 *	身份验证 
	 * @param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/validate")
	public void validate(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		PrintWriter printWriter = response.getWriter();
		
		String adminName = request.getParameter("adminName");
		System.out.println(adminName);
		String password = request.getParameter("password");
		
		System.out.println(password); 
		AdminService adminService = ctx.getBean("adminServiceImpl",AdminService.class);
		try {
			adminService.validate(adminName, password);
			Integer adminId = adminService.getAdminIdByName(adminName);
			System.out.println(adminId);
			request.getSession().setAttribute("adminId",adminId.toString());//把当前登录的管理员存入session
			printWriter.write("{\"res\":\"1\"}");
		} catch(AdminNoExistException e1){ //不存在
			printWriter.write("{\"res\":\"0\"}");
		} catch(AdminIsStopException e2) { //停用
			printWriter.write("{\"res\":\"2\"}");
		} catch(PasswordErrorException e3) {//密码错误
			printWriter.write("{\"res\":\"3\"}");
		} finally {
			printWriter.close();
		}
		
	}
	
	/**
	 * 退出系统 
	 * @param
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().removeAttribute("adminId");//删除当前用户信息
		return "redirect:"+"/adminLogin.jsp";
	}
}
