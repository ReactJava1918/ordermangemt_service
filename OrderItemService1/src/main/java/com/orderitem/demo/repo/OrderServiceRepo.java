package com.orderitem.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderitem.demo.model.OrderServiceHistory;
@Repository
public interface OrderServiceRepo extends JpaRepository<OrderServiceHistory,Integer> {
	
	 
	 

}
