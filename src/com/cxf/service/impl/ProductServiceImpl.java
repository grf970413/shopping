package com.cxf.service.impl;

import java.util.List;

import com.cxf.dao.ProductDao;
import com.cxf.pojo.Product;
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
}
