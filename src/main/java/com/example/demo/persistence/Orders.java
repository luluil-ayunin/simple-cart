package com.example.demo.persistence;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Long id;
	
	@OneToMany(mappedBy = "orderId", cascade = CascadeType.REMOVE)
	private Set<Cart> carts;

	public Orders() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Set<Cart> getCartId() {
		return carts;
	}

	public void setCartId(Set<Cart> cartId) {
		this.carts = cartId;
	}
	
}
