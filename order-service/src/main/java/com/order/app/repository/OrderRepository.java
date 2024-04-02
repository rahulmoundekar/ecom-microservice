package com.order.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
