package com.orderitem.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.orderitem.demo.model.OrderItem;
import com.orderitem.demo.model.OrderServiceHistory;
import com.orderitem.demo.repo.OrderServiceRepo;
import com.orderitem.demo.service.RemoteCallService;

@RestController
public class OrderServiceController {

	@Autowired
	private OrderServiceRepo orderservicerepo;
	@Autowired
    private RemoteCallService loadBalancer;

	 

	@RequestMapping(method = RequestMethod.POST, value = "/saveorderservice")
	public ResponseEntity<OrderServiceHistory> postorderservice(@RequestBody OrderServiceHistory data1) {

		OrderServiceHistory response = orderservicerepo.save(data1);

		ResponseEntity<OrderServiceHistory> a = new ResponseEntity<OrderServiceHistory>(response, HttpStatus.CREATED);

		return a;
	}
 
	
	

/*	@RequestMapping(value = "/employee2", method = RequestMethod.GET)
	public String getEmployee2() throws RestClientException, IOException {
		

		try {
			String emp = loadBalancer.getData();
			System.out.println(emp);
			return emp;
		} catch (Exception ex) {
			System.out.println(ex);
		}
	
		return "something went wrong";
	}
	*/
	
	@RequestMapping(value = "/getproducts", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<OrderItem>>> firstPage() throws RestClientException, IOException 
	{
		
		ResponseEntity<Map<String, List<OrderItem>>> emp = loadBalancer.firstPage();
		
		return emp;
		
		
	}
	
	
    @RequestMapping(method = RequestMethod.POST, value = "/saveproducts")
	public ResponseEntity<OrderItem> postData(@Valid @RequestBody OrderItem data1)throws RestClientException, IOException
    
    {
    	
    	ResponseEntity<OrderItem> postdata=loadBalancer.postData(data1);
    	
    	return postdata;
    }
	@RequestMapping(method = RequestMethod.GET, value = "/product/{name}")
	public ResponseEntity<OrderItem> getdataOnID(@PathVariable("name") String data) throws RestClientException, IOException
	
	{
		ResponseEntity<OrderItem> getdata = loadBalancer.getdataOnID(data);
		
		return getdata;
	}
	
	

}