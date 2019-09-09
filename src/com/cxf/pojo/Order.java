package com.cxf.pojo;

public class Order {
	private Integer id;
	private Integer userId;
	private java.sql.Date orderTime;
	private Integer amount;
	private Float sumPrice;
	private Product product;
	
	public Float getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Float sumPrice) {
		this.sumPrice = sumPrice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public java.sql.Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(java.sql.Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
