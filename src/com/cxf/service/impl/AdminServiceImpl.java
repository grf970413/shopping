package com.cxf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cxf.dao.AdminDao;
import com.cxf.exception.AdminIsStopException;
import com.cxf.exception.AdminNoExistException;
import com.cxf.exception.PasswordErrorException;
import com.cxf.pojo.Admin;
import com.cxf.service.AdminService;
import com.cxf.util.MD5Util;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {
	
	@Resource(name="adminDaoImpl")
	private AdminDao adminDao;
	
	@Override
	public void stopAdmin(String adminName) {
		adminDao.stopByName(adminName);
	}

	@Override
	public void startAdmin(String adminName) {
		adminDao.startByName(adminName);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	@Override
	public String getRoleByName(String adminName) {
		return adminDao.getRoleByName(adminName);
	}

	@Override
	public Integer getAdminIdByName(String adminName) {
		return adminDao.getAdminIdByName(adminName);
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}

	@Override
	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
	}

	@Override
	public Admin findAdminByName(String adminName) {
		return adminDao.findAdminByName(adminName);
	}

	/**
	 * 验证管理员身份
	 * @param
	 * @return
	 */
	@Override
	public void validate(String adminName, String password) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/cxf/pojo/applicationContext.xml");
		AdminDao adminDao = ctx.getBean("adminDaoImpl",AdminDao.class);
		//获取管理员对象
		Admin admin = adminDao.findAdminByName(adminName);
		//判断管理员是否存在
		if(null == admin) { //管理员不存在
			throw new AdminNoExistException();
		}
		//判断管理员是否被停用
		if(0 == admin.getStatus()) {
			throw new AdminIsStopException();
		}
		//判断密码是否正确
		if(!admin.getPassword().equals(MD5Util.toMd5(password))) {
			throw new PasswordErrorException();
		}
		
	}

	@Override
	public Admin getAdminById(Integer adminId) {
		return adminDao.getAdminById(adminId);
	}
	
}
