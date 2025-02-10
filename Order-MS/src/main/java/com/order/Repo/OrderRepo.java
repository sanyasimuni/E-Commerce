package com.order.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.Entity.Order;

@Repository
public interface OrderRepo  extends JpaRepository<Order, Integer> {
	
	//List<Order>findByProduct(Integer productId);
	//List<Order> findByProduct_ProductId(Integer productId);
	//List<Order> findByProduct_ProductId(Integer productId);
	List<Order> findByProductId(Integer productId);



}
