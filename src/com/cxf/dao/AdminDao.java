package com.cxf.dao;

import java.util.List;

import com.cxf.pojo.Admin;

public interface AdminDao {
	public void stopByName(String adminName);//停用管理员
	public void startByName(String adminName);
	public List<Admin> getAllAdmin(); //获取所有管理员
	public String getRoleByName(String adminName);
	public Integer getAdminIdByName(String adminName);
	public void updateAdmin(Admin admin); //更新管理员信息
	public void addAdmin(Admin admin);
	public Admin findAdminByName(String adminName);
	public Admin getAdminById(Integer adminId);//通过管理员编号获取管理员对象
}
