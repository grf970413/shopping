package com.cxf.service;

import java.util.List;

import com.cxf.pojo.Product;

public interface ProductService {
	public List<Product> getProductBySortId(Integer sortId);//通过副产品id获得产品
	public String getByProductNameById(Integer id);//通过副产品id找副产品名字
	public Product getProductByName(String name);
}
