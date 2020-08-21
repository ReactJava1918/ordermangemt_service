package com.orderitem.demo.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orderitem.demo.model.OrderItem;



@FeignClient(name="orderitemservice-1")
public interface RemoteCallService {
 
	 
	
	@RequestMapping(value = "/getproducts", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<OrderItem>>> firstPage() ;
    @RequestMapping(method = RequestMethod.POST, value = "/saveproducts")
	public ResponseEntity<OrderItem> postData(@Valid @RequestBody OrderItem data1);
	@RequestMapping(method = RequestMethod.GET, value = "/product/{name}")
	public ResponseEntity<OrderItem> getdataOnID(@PathVariable("name") String data);

		 
 

	
	

}