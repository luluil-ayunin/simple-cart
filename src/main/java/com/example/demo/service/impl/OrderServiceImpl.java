package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.Orders;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders addOrder(Orders newOrder) {
		return ordersRepository.save(newOrder);
	}

}
