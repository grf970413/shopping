package com.cxf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cxf.dao.ShopcartDao;
import com.cxf.pojo.Shopcart;
import com.cxf.service.ShopcartService;

@Service("shopcartServiceImpl")
public class ShopcartServiceImpl implements ShopcartService {
	
	@Resource(name="shopcartDao")
	private ShopcartDao shopcartDao;
	
	/**
	  *   获取购物车列表
	 * @param
	 * @return
	 */
	@Override
	public List<Shopcart> getShopcartByUserName(String userName) {
		return shopcartDao.getShopcartByUserName(userName);
	}
}
