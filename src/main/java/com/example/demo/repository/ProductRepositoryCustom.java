package com.example.demo.repository;

import java.util.List;

import com.example.demo.persistence.Product;

public interface ProductRepositoryCustom {
	List<Product> getProductByName(String name);

}
