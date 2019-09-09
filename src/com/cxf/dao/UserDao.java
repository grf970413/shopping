package com.cxf.dao;

import com.cxf.pojo.User;

public interface UserDao {
	public User getUserByName(String userName);
	public Integer getUserIdByName(String userName);
}
