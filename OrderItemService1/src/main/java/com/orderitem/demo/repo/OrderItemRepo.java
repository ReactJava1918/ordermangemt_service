package com.orderitem.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderitem.demo.model.OrderItem;
@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {
	
	public  List<OrderItem> findAll(); 
	public OrderItem  save(OrderItem entity);
	public Optional<OrderItem> findByProductid(Integer data);
	public Optional<OrderItem> findByProductName(String productname);
	 

}
