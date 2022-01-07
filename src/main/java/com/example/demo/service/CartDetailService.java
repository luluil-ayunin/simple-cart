package com.example.demo.service;

import java.util.List;

import com.example.demo.persistence.CartDetail;

public interface CartDetailService {
	List<CartDetail> getAllCartDetail();
	CartDetail addCartDetail(CartDetail cartDetail);
	CartDetail updateCartDetail(Long id, CartDetail cartDetail);
	void deleteCartDetail(Long id);
}
