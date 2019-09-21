package com.cxf.service.impl;

import java.util.List;

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
	/**
	 * 通过用户名获取用户ID
	 * @param
	 * @return
	 */
	@Override
	public Integer getUserIdByName(String userName) {
		return userDao.getUserIdByName(userName);
	}
	/**
	 * 添加用户
	 * @param
	 * @return
	 */
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	/**
	 * 更新用户信息
	 * @param
	 * @return
	 */
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User findUserById(Integer userId) {
		return userDao.findUserById(userId);
	}
	@Override
	public Integer getUserIdByUserName(String userName) {
		return userDao.getUserIdByUserName(userName);
	}
	/**
	 *
	 * @param
	 * @return
	 */
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
	@Override
	public void validate(String userName, String password) throws Exception {
		
	}
	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
	
}
