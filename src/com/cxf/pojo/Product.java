package com.cxf.pojo;

public class Product {
	private Integer id;
	private String productName;
	private int stock;
	private float price;
	private String imgAddress;
	private String info;
	private int buyed;
	private float refPrice;
	private Integer typeId;
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public float getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(float refPrice) {
		this.refPrice = refPrice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImgAddress() {
		return imgAddress;
	}
	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getBuyed() {
		return buyed;
	}
	public void setBuyed(int buyed) {
		this.buyed = buyed;
	}
}
