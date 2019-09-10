package com.cxf.service;

import java.util.List;

import com.cxf.pojo.Product;
import com.cxf.pojo.Sort;

public interface ProductService {
	public Product getProductByName(String name); //通过产品名字查找产品
	public List<Product> getProductBySortId(Integer sortId);//通过副产品id获得产品
	public String getSortNameBySortId(Integer id);//通过副产品id找副产品名字
	public Product getProductById(Integer id);
	
	public int updateProduct(Product product);
	public List<String> getType();//获得主产品
	public List<Sort> getSort(String typeName);//获得副产品
	
	public String getByProductNameById(Integer id);//通过副产品id找副产品名字
}
