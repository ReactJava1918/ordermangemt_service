package com.orderitem.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.orderitem.demo.repo.OrderItemRepo;
import com.orderitem.demo.repo.OrderServiceRepo;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderItemServiceApplication {
	

	@Autowired
	private OrderItemRepo orderitemrepo;
	
	@Autowired
	private OrderServiceRepo orderservicerepo;

	public static void main(String[] args) {
		 SpringApplication.run(OrderItemServiceApplication.class, args);
		 
	}
	
	
	/* 
	public void postData() {
		
		 
		OrderItem data =new OrderItem();
		data.setProductCode("saoapsiva1");
		//data.setProductid(1);
		data.setProductName("soap");
		data.setProductQuantity(1);
	 

		OrderItem response = orderitemrepo.save(data);
		
		System.out.println("data successfully saved.........");
	 
	}
	
	
	public void postDataorderservice() {
		ArrayList<OrderServiceItem> data2 =new ArrayList<OrderServiceItem>();
		 
		OrderServiceHistory data =new OrderServiceHistory();
		
		data.setCustomerName("siva");
		data.setShippingAddress("hyd");
		data.setTotal(100);
		 OrderServiceItem a11=new OrderServiceItem();
		 a11.setProductid(1);
		 data2.add(a11);
		 OrderServiceItem a12=new OrderServiceItem();
		 a12.setProductid(2);
		data2.add(a12);
		data.setServiceitem(data2);
		
		 orderservicerepo.save(data);  
		     
	
		
		System.out.println("data successfully saved.........");
	 
	}
*/
}
