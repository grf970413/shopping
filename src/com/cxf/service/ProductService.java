package com.cxf.service;

import java.util.List;
import java.util.Map;

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
	
	public void addType(String typeName) throws Exception;
	public void deleteSort(String sortName);
	public void addSort(Map<Object,Object> map) throws Exception;
	public void renameSort(Map<Object,Object> map) throws Exception;
	public void renameType(Map<Object,Object> map) throws Exception;
	public void deleteType(String typeName);//删除类别
	public List<String> getAllTypeName(); //获取所有产品类型名称
	public Integer getTypeIdByTypeName(String typeName);
	public Integer getProductIdByName(String productName);
	public List<Product> getProductByTypeId(Integer typeId); //通过分类ID获取产品
	
	public List<Product> getProductBySortName(String name); //通过分类名称查找产品 
	
	//public boolean updateProductById(Integer id); //通过产品ID更新产品信息
	
	public List<Product> getProductBypaging(Map<String,Object> map);
	public int getTotalBySortName(String sortName); //获取某一分类的总记录数
	
	public List<String> getSortListByTypeId(Integer typeId);
	public List<String> getTypeList(); //获取一级分类
	public void addProduct(Product product);//添加产品
	public Integer getSortIdBySortName(String sortName); //通过分类名称查询分类ID
	public Integer getTypeIdBySortId(Integer sortId); //根据分类ID获取类别ID
	public String getTypeNameByTypeId(Integer typeId);

	public void deleteProduct(String productName);
	
}
