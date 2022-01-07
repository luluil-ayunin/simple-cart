package com.example.demo.service;

import java.util.List;

import com.example.demo.persistence.Cart;

public interface CartService {
	List<Cart> getCartsByOrder(Long orderId);
	List<Cart> getCarts();
	Cart getCartById(Long id);
	Cart addCart(Cart newCart);
	Cart updateCart(Long id, Cart cart);
	Void deleteCart(Long id);
	Cart setToOrder(Long id, Cart cart);
}
