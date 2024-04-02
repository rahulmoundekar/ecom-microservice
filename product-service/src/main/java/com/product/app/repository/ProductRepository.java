package com.product.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
