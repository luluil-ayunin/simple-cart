package com.example.demo.businessprocess;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controller.response.CartInputRequest;
import com.example.demo.controller.response.CartUpdateQtyRequest;
import com.example.demo.persistence.Cart;
import com.example.demo.persistence.CartDetail;
import com.example.demo.persistence.Product;
import com.example.demo.service.CartDetailService;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@Component
public class CartHandler {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private CartDetailService cartDetailService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	
	public Cart addCart(CartInputRequest cartInputRequest) {
		Product selectedProduct = getProductById(cartInputRequest.getProductId());
		CartDetail cartDetail = insertCartDetail(selectedProduct, cartInputRequest.getQuantity());
		
		Cart cart = new Cart();
		cart.setCartDetail(cartDetail);
		cart.setUser(userService.getUserById(cartInputRequest.getUserId()));
		
		return cartService.addCart(cart);
	}

	public Cart updateQtyCart(CartUpdateQtyRequest cartUpdateQtyRequest) {
		Cart updatedCart = cartService.getCartById(cartUpdateQtyRequest.getCartId());
		CartDetail cartDetail = updatedCart.getCartDetail();
		cartDetail.setQuantity(cartDetail.getQuantity()+cartUpdateQtyRequest.getQty());
		cartDetailService.updateCartDetail(updatedCart.getCartDetail().getId(), cartDetail);

		return updatedCart;
	}
	
	public Product getProductById(Long id) {
		return productService.getOneproduct(id);
	}
	
	public CartDetail insertCartDetail(Product product, int quantity) {
		BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
		
		CartDetail cartDetail = new CartDetail();
		cartDetail.setProductEntity(product);
		cartDetail.setQuantity(quantity);
		cartDetail.setTotalprice(totalPrice);
		return cartDetailService.addCartDetail(cartDetail);
	}

}
