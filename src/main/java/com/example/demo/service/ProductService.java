package com.example.demo.service;

import java.util.List;

import com.example.demo.persistence.Product;

public interface ProductService {
	List<Product> getProducts();
	Product getOneproduct(Long id);
	List<Product> searchProducts(String name);
}
