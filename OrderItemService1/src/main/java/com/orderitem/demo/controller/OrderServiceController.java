package com.orderitem.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderitem.demo.model.OrderItem;
import com.orderitem.demo.model.OrderServiceHistory;
import com.orderitem.demo.repo.OrderServiceRepo;

@RestController
public class OrderServiceController {

	@Autowired
	private OrderServiceRepo orderservicerepo;

	 

	@RequestMapping(method = RequestMethod.POST, value = "/saveorderservice")
	public ResponseEntity<OrderServiceHistory> postorderservice(@RequestBody OrderServiceHistory data1) {

		OrderServiceHistory response = orderservicerepo.save(data1);

		ResponseEntity<OrderServiceHistory> a = new ResponseEntity<OrderServiceHistory>(response, HttpStatus.CREATED);

		return a;
	}
 

}