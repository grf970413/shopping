package com.cxf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cxf.dao.UserDao;
import com.cxf.pojo.User;
import com.cxf.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Resource(name="userDaoImpl")
	private UserDao userDao = null; 
	
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
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
