package com.example.demo.businessprocess;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.persistence.Cart;
import com.example.demo.persistence.Orders;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;

@Component
public class OrderHandler {

	@Autowired 
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	
	public Orders placeOrder(List<Long> carts) {
		Orders newOrder = new Orders();
		newOrder.setCartId(setCarts(carts));
		
		return orderService.addOrder(newOrder);
	}
	
	/**
	 * @param cartsId
	 * @return
	 */
	public Set<Cart> setCarts(List<Long> cartsId){
		List<Cart> cartsList = new ArrayList<>();
		cartsId.forEach((cartId) -> {
			Cart cart = cartService.getCartById(cartId);
			cartsList.add(cart);
		});
		
		Set<Cart> cartSet = cartsList.stream().collect(Collectors.toSet());
		return cartSet;	
	}
}
