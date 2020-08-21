package com.orderitem.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderitem.demo.custom_Exception.ProductNotfoundException;
import com.orderitem.demo.model.OrderItem;
import com.orderitem.demo.repo.OrderItemRepo;
import com.orderitem.demo.validator.OrderItemValidator;

@RestController
public class TestController {

	@Autowired
	private OrderItemRepo orderitemrepo;
	  
	@Autowired
	private OrderItemValidator prv;
	
	
	
	@InitBinder
	public void init(WebDataBinder web)
	{
		System.out.println("in to controller----------------");
		  web.addValidators(prv);
		
		
	}

	@RequestMapping(value = "/getproducts", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<OrderItem>>> firstPage() {

		List<OrderItem> findAll =orderitemrepo.findAll();

		HashMap<String, List<OrderItem>> horderitems = new HashMap<String, List<OrderItem>>();
		horderitems.put("products", findAll);
		ResponseEntity<Map<String, List<OrderItem>>> orderitemlist = new ResponseEntity<Map<String, List<OrderItem>>>(
				horderitems, HttpStatus.OK);
		return orderitemlist;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveproducts")
	public ResponseEntity<OrderItem> postData(@Valid @RequestBody OrderItem data1) {
		 
		
		 

		OrderItem response = orderitemrepo.save(data1);
		

			ResponseEntity<OrderItem> a = new ResponseEntity<OrderItem>(response, HttpStatus.CREATED);

		 

		return a;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/product/{name}")
	public ResponseEntity<OrderItem> getdataOnID(@PathVariable("name") String data) {

		 

		Optional<OrderItem> response = orderitemrepo.findByProductName(data);
		if(response.isPresent())
		{

		OrderItem o = response.get();

		ResponseEntity<OrderItem> a = new ResponseEntity<OrderItem>(o, HttpStatus.OK);
		return a;
		
		}
		else
		{
			throw new ProductNotfoundException();
		}

	}

}