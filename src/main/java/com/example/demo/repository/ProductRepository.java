package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.Product;

@EnableJpaRepositories
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("select p from Product p where p.productName like concat('%',:name,'%')")
	List<Product> getProductByName(@Param("name") String name);
	
	List<Product> findByProductNameIgnoreCaseContaining(String productName);
	
}
