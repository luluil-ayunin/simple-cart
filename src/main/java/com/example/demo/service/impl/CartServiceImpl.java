package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public List<Cart> getCarts() {
		return cartRepository.findAll();
	}

	@Override
	public Cart addCart(Cart newCart) {
		return cartRepository.save(newCart);
	}

	@Override
	public Void deleteCart(Long id) {
		cartRepository.deleteById(id);
		return null;
	}

	@Override
	public List<Cart> getCartsByOrder(Long orderId) {
		return cartRepository.getCartByOrder(orderId);
	}

	@Override
	public Cart getCartById(Long id) {
		return cartRepository.getById(id);
	}

	@Override
	public Cart setToOrder(Long id, Cart cart) {
		Cart updatedCart = cartRepository.getById(id);
		updatedCart.setOrderId(cart.getOrderId());
		return cartRepository.save(updatedCart);
	}

	@Override
	public Cart updateCart(Long id, Cart cart) {
		Cart updatedCart = cartRepository.getById(id);
		updatedCart.setCartDetail(cart.getCartDetail());
		return cartRepository.save(updatedCart);
	}

}
