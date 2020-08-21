
package com.orderitem.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class  OrderItem {
	 @Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	// @JsonIgnore
	private Integer productid;
   
	 @NotEmpty(message = "Please provide a ProductCode")
	private String ProductCode;
	
	
	
    @NotEmpty(message = "Please provide a productname")
    private String productName;
    
    @NotNull(message = "Please provide a price")
    private Integer productQuantity;
	
	
	 
	 
}
