package com.cxf.dao;

import java.util.List;

import com.cxf.pojo.User;

public interface UserDao {
	public User getUserByName(String userName);
	public Integer getUserIdByName(String userName); //通过用户名查找用户ID
	public void addUser(User user);
	
	
	public void updateUser(User user); //更新用户信息
	public User findUserById(Integer id);
	public User findUserByUserName(String userName);
	public List<User> getAllUser(); //获取所有用户
	public Integer insertUser(User user); 
	public Integer deleteUser(User user); 

	public Integer getIdByUserName(String userName); 
	public String getPasswordByUserName(String name); 
	
}
