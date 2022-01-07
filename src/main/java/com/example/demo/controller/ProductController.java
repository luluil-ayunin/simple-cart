package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/get-all-product")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> products = productService.getProducts();
		return ResponseEntity.ok().body(products);
	}
	
	@PostMapping("/get-product")
	public ResponseEntity<Product> getOneProduct(@RequestBody Long id){
		Product product = productService.getOneproduct(id);
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping("/search-product")
	public ResponseEntity<List<Product>> getProductByName(@RequestBody String name){
		List<Product> products = productService.searchProducts(name);
		return ResponseEntity.ok().body(products);
	}
}
