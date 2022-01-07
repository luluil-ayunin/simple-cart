package com.example.demo.service;

import com.example.demo.persistence.Orders;

public interface OrderService {
	Orders addOrder(Orders newOrder);
}
