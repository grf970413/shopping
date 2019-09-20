package com.cxf.service;

import java.util.List;

import com.cxf.pojo.User;

public interface UserService {
	public User getUserByName(String userName);
	public Integer getUserIdByName(String userName);
	public void addUser(User user); //添加用户
	public void updateUser(User user); //更新用户信息

	public User findUserById(Integer userId); //通过用户ID查找用户
	public Integer getUserIdByUserName(String userName);
	public List<User> getAllUser();
	public void validate(String userName,String password) throws Exception; //验证身份
	public void deleteUser(User user);//删除用户

}
