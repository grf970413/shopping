package com.cxf.service.impl;

import java.util.List;
import java.util.Map;

import com.cxf.dao.ProductDao;
import com.cxf.pojo.Product;
import com.cxf.pojo.Sort;
import com.cxf.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	/**
	 *
	 * @param
	 * @return
	 */
	@Override
	public List<Product> getProductBySortId(Integer sortId) {
		return productDao.getProductBySortId(sortId);
	}


	/**
	  *  通过副产品id去查找副产品名字
	 * @param 副产品id
	 * @return 副产品名字
	 */
	@Override
	public String getByProductNameById(Integer id) {
		return productDao.getByProductNameById(id);
		}
	@Override
	public Product getProductByName(String name) {
		return productDao.getProductByName(name);
	}

	@Override
	public String getSortNameBySortId(Integer id) {
		return productDao.getByProductNameById(id);
	}

	@Override
	public Product getProductById(Integer id) {
		return productDao.getProductById(id);
	}

	@Override
	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public List<String> getType() {
		return productDao.getType();
	}

	@Override
	public List<Sort> getSort(String typeName) {
		return productDao.getSort(typeName);
	}
	///////////////////////

	@Override
	public void addType(String typeName) throws Exception {
		if(null != productDao.findTypeByTypeName(typeName)) { //名称已存在
			throw new Exception();
		} else {
			productDao.addType(typeName);
		}
	}

	@Override
	public void deleteSort(String sortName) {
		if(sortName.equals("新子分类")) {
			productDao.realDeleteSort(sortName);
		} else {
			productDao.deleteSort(sortName);
		}
	}

	/**
	 * 添加二级分类
	 * @param typeId,sortName
	 * @return 
	 */
	@Override
	public void addSort(Map<Object, Object> map) throws Exception {
		if (null != productDao.findSortByName((String)map.get("sortName"))) { //分类名称已存在
			throw new Exception();
		} else {
			productDao.addSort(map);
		}
	}

	@Override
	public void renameSort(Map<Object, Object> map) throws Exception {
		map.put("sortId",productDao.getSortIdBySortName((String)map.get("sortName")));
		if(null != productDao.findSortNameByNewName(map)) { //如果新名称已经存在
			throw new Exception();
		} else {
			productDao.renameSort(map);
		}
	}

	@Override
	public void renameType(Map<Object, Object> map) throws Exception {
		if(null != productDao.findTypeNameByNewName((String)map.get("newName"))) { //如果新名称已经存在
			 throw new Exception();
		} else { //不存在就修改
			productDao.renameType(map); 
		}
	}

	@Override
	public void deleteType(String typeName) {
		if(typeName.equals("新分类")) {
			productDao.realDeleteType(typeName);
		} else {
			productDao.deleteType(typeName);
		}
	}

	@Override
	public List<String> getAllTypeName() {
		return productDao.getAllType();
	}

	@Override
	public Integer getTypeIdByTypeName(String typeName) {
		return productDao.getTypeIdByTypeName(typeName);
	}

	
	

	@Override
	public List<Product> getProductBypaging(Map<String, Object> map) {
		return productDao.getProductByPaging(map);
	}

	@Override
	public int getTotalBySortName(String sortName) {
		return productDao.getTotalBySortName(sortName);
	}

	@Override
	public List<String> getSortListByTypeId(Integer typeId) {
		return productDao.getSortListByTypeId(typeId);
	}

	@Override
	public List<String> getTypeList() {
		return productDao.getTypeList();
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public Integer getSortIdBySortName(String sortName) {
		return productDao.getSortIdBySortName(sortName);
	}

	@Override
	public Integer getTypeIdBySortId(Integer sortId) {
		return productDao.getTypeIdBySortId(sortId);
	}

	@Override
	public String getTypeNameByTypeId(Integer typeId) {
		return productDao.getTypeNameByTypeId(typeId);
	}

	@Override
	public void deleteProduct(String productName) {
		productDao.deleteProduct(productName);
	}
	
	@Override
	public Integer getProductIdByName(String productName) {
		return productDao.getProductIdByName(productName);
	}

	@Override
	public List<Product> getProductByTypeId(Integer typeId) {
		return null;
	}

	@Override
	public List<Product> getProductBySortName(String name) {
		return null;
	}
}
