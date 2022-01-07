package com.example.demo.persistence;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User{
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;
	private String name;
	private String password;
	
	@Column(unique = true)
	private String email;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.REMOVE)
	@Column(name = "cart_id", nullable = true)
	private Set<Cart> cart;

	public User() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}
}
