package com.cxf.dao;

import java.util.List;
import java.util.Map;

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
	public void addType(String typeName);
	public void deleteType(String typeName);
	public void updateType(Map<String,String> map);
	public void addSort(Map<Object,Object> map);
	public void deleteSort(String sortName);
	public void updateSortStatus(Map<String,String> map); //更新分类的状态
	public String findSortByName(String sortName); //查找分类是否存在
	public void renameSort(Map<Object,Object> map); //重命名分类
	public String findTypeByTypeName(String typeName);
	public String findSortNameByNewName(Map<Object,Object> map); //通过新名字查找表中是否存在
	public void renameType(Map<Object,Object> map);//一级分类重命名
	public String findTypeNameByNewName(String typeName); //通过新名字查找表中是否存在
	public void realDeleteType(String typeName);//真实删除二级分类
	public void realDeleteSort(String sortName);//真实删除一级分类
	public Integer getTypeIdByTypeName(String typeName);//
	public List<String> getSortListByTypeId(Integer typeId);
	public List<String> getAllType();//获取所有一级分类 
	public Integer getTypeIdBySortId(Integer sortId); //根据分类ID获取类别ID
	public String getTypeNameByTypeId(Integer typeId);
	public String getSortNameBySortId(Integer sortId);
	public void deleteProduct(String productName);
	public List<String> getTypeList(); //获取一级分类
	public Integer getSortIdBySortName(String sortName);
	public int getTotalBySortName(String sortName); //获取某一分类的总记录数
	public List<Product> getProductByPaging(Map<String,Object> map); //分页获取产品
	public int addProduct(Product product);//添加商品
	public Integer getProductIdByName(String productName); //通过产品名称获取产品ID
	public Integer getTypeAtRow(Integer typeId);//获取一级分类记录条数
	public Integer getSortAtRow(Map<Object,Object> map);
}
