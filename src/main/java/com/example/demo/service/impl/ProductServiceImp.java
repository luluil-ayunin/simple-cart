package com.example.demo.service.impl;

//import static org.mockito.ArgumentMatchers.contains;

import java.util.List;

import org.hibernate.graph.CannotContainSubGraphException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
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
		return productRepository.findAll();
	}

	@Override
	public Product getOneproduct(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public List<Product> searchProducts(String name) {
		StringBuilder builder = new StringBuilder();
		builder.append('%'+name+'%');
		String keyword = builder.toString();
		System.err.println(name);
		System.out.println("%"+name+"%");
		System.err.println(keyword);
		List<Product> products = productRepository.findByProductNameContaining(name);
		return products;
	}

}
