package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.CartDetail;

@EnableJpaRepositories
@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{

	@Query(value="select * from cart_detail"
			+ "from cart_detail d "
			+ "join cart c"
			+ "on d.cart_id = c.cart_id"
			+ "where c.order_id = :orderId", 
			nativeQuery=true)
	List<CartDetail> getCartDetailByOrder(Long orderId);
}
