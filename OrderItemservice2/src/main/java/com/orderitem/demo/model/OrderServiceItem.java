
package com.orderitem.demo.model;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class  OrderServiceItem {
	 @Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	// @JsonIgnore
	private Integer orderServiceitemId;
	
	private Integer productid;
	 
	 
}
