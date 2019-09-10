package com.cxf.service;

import com.cxf.pojo.User;

public interface UserService {
	public User getUserByName(String userName);
	public Integer getUserIdByName(String userName);
	public void addUser(User user); //添加用户
}
