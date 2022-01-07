package com.example.demo.service;

import java.util.List;

import com.example.demo.persistence.Cart;

public interface CartService {
	List<Cart> getCartsByOrder(Long orderId);
	List<Cart> getCarts();
	Cart getCartById(Long id);
	Cart addCart(Cart newCart);
	Cart updateQuantity(Long id, int qty);
	Void deleteCart(Long id);

}
