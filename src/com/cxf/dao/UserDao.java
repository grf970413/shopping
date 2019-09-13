package com.cxf.dao;

import com.cxf.pojo.User;

public interface UserDao {
	public User getUserByName(String userName);
	public Integer getUserIdByName(String userName); //通过用户名查找用户ID
	public void addUser(User user);
	
	
	public void updateUser(User user); //更新用户信息
}
