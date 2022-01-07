package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;


	@Override
	public List<Product> getProducts() {
		List<Product> products = productRepository.findAll();

		return products;
	}

	@Override
	public Product getOneproduct(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public List<Product> searchProducts(String name) {
		
		return productRepository.getProductByName(name);
	}

}
