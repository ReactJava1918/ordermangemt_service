package com.orderitem.demo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.orderitem.demo.model.OrderItem;
import com.orderitem.demo.repo.OrderItemRepo;



/**
 * @author imssbora
 */
@Component
public class OrderItemValidator implements Validator {
	

	@Autowired
	private OrderItemRepo orderitemrepo;
	

   @Override
   public boolean supports(Class<?> clazz) {
      return OrderItem.class.equals(clazz);
   }

   @Override
	public void validate(Object obj, Errors err) {

		OrderItem otem = (OrderItem) obj;

		Optional<OrderItem> data = orderitemrepo.findByProductName(otem.getProductName());

		if (data.isPresent()) {

			err.rejectValue("productName", "500", "" + otem.getProductName() + " already avialble");

		}

		if (otem.getProductQuantity() < 1) {
			ValidationUtils.rejectIfEmpty(err, "productName", "500", "" + otem.getProductName() + " already avialble");

			err.rejectValue("productQuantity", "500", "qunatitey should be greater than 1");
		}

		// ValidationUtils.rejectIfEmpty(err, "name", "user.name.empty");
		// ValidationUtils.rejectIfEmpty(err, "email", "user.email.empty");
		// ValidationUtils.rejectIfEmpty(err, "phone", "user.phone.empty");

		 
   
   }

}