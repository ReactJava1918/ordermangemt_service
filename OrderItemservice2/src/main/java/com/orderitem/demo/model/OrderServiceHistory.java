
package com.orderitem.demo.model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class  OrderServiceHistory {
	 @Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	// @JsonIgnore
	private Integer orderservieId;
	
	private String customerName;
	/*@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date orderDate;*/
	private Integer total;
	private String shippingAddress;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
   private Date orderDate;
	
	
	@OneToMany(cascade=CascadeType.ALL)  
	 private List<OrderServiceItem> serviceitem ;
	 
	
	 

	 
}
