package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.example.demo.persistence.Product;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Product> getProductByName(String name) {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Product> query = cb.createQuery(Product.class);
		String hql = "FROM Product as p WHERE p.productName LIKE ";
		return null;
	}

}
