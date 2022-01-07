package com.example.demo.controller.response;

import java.util.Set;

import com.example.demo.persistence.Cart;
import com.example.demo.persistence.Orders;

public class OrdersResponse {
	String state;
	Orders id;
	Set<Cart> carts;
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Orders getId() {
		return id;
	}
	public void setId(Orders id) {
		this.id = id;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

}
