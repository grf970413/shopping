package com.cxf.dao;

import java.util.List;

import com.cxf.pojo.By;
import com.cxf.pojo.Product;

public interface ProductDao {
	public Product getProductById(Integer id);
	public Product getProductByName(String name);
	public int updateProduct(Product product);
	public List<String> getMainPro();//获得主产品
	public List<By> getByPro(String mainProName);//获得副产品
	public List<Product> getProductBySortId(Integer sortId);//通过副产品id获得产品
	public String getByProductNameById(Integer id);//通过副产品id找副产品名字
}
