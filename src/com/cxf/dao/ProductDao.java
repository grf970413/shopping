package com.cxf.dao;

import java.util.List;
import com.cxf.pojo.Product;
import com.cxf.pojo.Sort;

public interface ProductDao {
	public Product getProductById(Integer id);
	public Product getProductByName(String name);
	public int updateProduct(Product product);
	public List<String> getType();//获得主产品
	public List<Sort> getSort(String typeName);//获得副产品
	public List<Product> getProductBySortId(Integer sortId);//通过副产品id获得产品
	public String getByProductNameById(Integer id);//通过副产品id找副产品名字
}
