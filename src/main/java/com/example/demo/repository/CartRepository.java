package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.persistence.Cart;

@EnableJpaRepositories
@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    @Modifying
    @Query(value="update Cart c set c.quantity= :quantity where c.id = :id"
    		,nativeQuery=true)
    Cart updateQuantity(Long id, int quantity);
    
    @Query(value="select * from cart c"
    		+ "join order o"
    		+ "on c.order_id = o.order_id"
    		+ "where o.order_id=:orderId"
    		,nativeQuery=true)
    List<Cart> getCartByOrder(Long orderId);
    
}
