package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.Product;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value="select p from product p where p.product_name like :name"
			, nativeQuery=true)
	List<Product> getProductByName(String name);
	
	List<Product> findByProductNameContaining(String productName);
}
