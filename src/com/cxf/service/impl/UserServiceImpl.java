package com.cxf.service.impl;

import com.cxf.dao.UserDao;
import com.cxf.pojo.User;
import com.cxf.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = null; 
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 通过用户名查找用户
	 * @param
	 * @return
	 */
	@Override
	public User getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}
	@Override
	public Integer getUserIdByName(String userName) {
		return userDao.getUserIdByName(userName);
	}
}
