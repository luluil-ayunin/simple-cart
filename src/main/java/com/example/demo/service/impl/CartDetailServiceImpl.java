package com.example.demo.service.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.CartDetail;
import com.example.demo.repository.CartDetailRepository;
import com.example.demo.service.CartDetailService;

@Service
public class CartDetailServiceImpl implements CartDetailService{

	@Autowired
	CartDetailRepository cartDetailRepository;
	
	@Override
	public List<CartDetail> getAllCartDetail() {
		List<CartDetail> cartDetails = cartDetailRepository.findAll();
		return cartDetails;
	}

	@Override
	public List<CartDetail> getCartDetailByOrder(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDetail addCartDetail(CartDetail cartDetail) {
		CartDetail insertedCartDetail = cartDetailRepository.save(cartDetail);
		return insertedCartDetail;
	}

	@Override
	public CartDetail updateCartDetail(Long id, CartDetail cartDetail) {
		CartDetail updatedCartDetail = cartDetailRepository.getById(id);
		updatedCartDetail.setQuantity(cartDetail.getQuantity());
		updatedCartDetail.setTotalprice(cartDetail.getTotalprice());
		updatedCartDetail.setUpdatedDate(Instant.now());
		return cartDetailRepository.saveAndFlush(updatedCartDetail);
	}

	@Override
	public void deleteCartDetail(Long id) {
		cartDetailRepository.deleteById(id);
	}

}
