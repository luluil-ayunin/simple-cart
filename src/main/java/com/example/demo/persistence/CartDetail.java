package com.example.demo.persistence;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "cart_detail")
public class CartDetail {
	@Id
	@GeneratedValue
	@Column(name = "cart_detail_id")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id")	
	private Product product;
	
	@OneToOne(mappedBy = "cartDetail",cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Cart cart;
	
	private int quantity;
	
	@Column(name = "total_price")
	private BigDecimal totalprice;
	@CreationTimestamp
	private Instant createdDate;
	@UpdateTimestamp
	private Instant updatedDate;
	
	public CartDetail() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProductEntity() {
		return product;
	}

	public void setProductEntity(Product productEntity) {
		this.product = productEntity;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public Instant getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Instant updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
