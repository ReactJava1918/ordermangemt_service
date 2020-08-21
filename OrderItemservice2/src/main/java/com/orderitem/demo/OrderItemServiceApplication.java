package com.orderitem.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.orderitem.demo.model.OrderItem;
import com.orderitem.demo.repo.OrderItemRepo;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderItemServiceApplication {
	

	@Autowired
	private OrderItemRepo orderitemrepo;

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(OrderItemServiceApplication.class, args);
		OrderItemServiceApplication  cal	=run.getBean(OrderItemServiceApplication.class);
		 
		
		cal.postData();
	}
	
	
	 
	public void postData() {
		
		 
		OrderItem data =new OrderItem();
		data.setProductCode("saoapsiva1");
		//data.setProductid(1);
		data.setProductName("soap");
		data.setProductQuantity(1);
	 

		OrderItem response = orderitemrepo.save(data);
		
		System.out.println("data successfully saved.........");
	 
	}

}
