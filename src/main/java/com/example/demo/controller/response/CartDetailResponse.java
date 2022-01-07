package com.example.demo.controller.response;

import java.math.BigDecimal;
import java.time.Instant;

public class CartDetailResponse {

	Long id;	
	ProductResponse product;
	int quantity;
	BigDecimal totalprice;
	Instant createdDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProductResponse getProduct() {
		return product;
	}
	public void setProduct(ProductResponse product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}
	public Instant getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
