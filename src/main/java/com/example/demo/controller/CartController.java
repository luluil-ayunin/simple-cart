package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessprocess.CartHandler;
import com.example.demo.businessprocess.OrderHandler;
import com.example.demo.controller.response.CartInputRequest;
import com.example.demo.controller.response.CartUpdateQtyRequest;
import com.example.demo.controller.response.OrdersResponse;
import com.example.demo.persistence.Cart;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	private CartHandler cartHandler;
	@Autowired
	private OrderHandler orderHandler;
	
	@PostMapping("/cart-add")
	public ResponseEntity<Cart> addCart(@RequestBody CartInputRequest cartInputRequest) {
		Cart inputCart = cartHandler.addCart(cartInputRequest);
		return ResponseEntity.ok().body(inputCart);
	}
	
	@PostMapping("/place-order")
	public ResponseEntity<OrdersResponse> placeOrder(@RequestBody List<Long> cartsId){
		OrdersResponse response = orderHandler.placeOrder(cartsId);
		return ResponseEntity.ok().body(response);	
	}
	
	@PostMapping("/update-qty")
	public ResponseEntity<Cart> updateQuantity(@RequestBody CartUpdateQtyRequest cartUpdate){
		Cart updateCart = cartHandler.updateQtyCart(cartUpdate);
		return ResponseEntity.ok().body(updateCart);
	}
	
}
