package com.orderitem.demo.exception_handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.orderitem.demo.custom_Exception.ProductNotfoundException;



//@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ApiErrorHandler    {
	
	
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public Map<String, String> handleValidationExceptions(
	    MethodArgumentNotValidException ex) {
		//  System.out.println("control coming to here............");
	      Map<String, String> errors = new HashMap<String, String>();
	      ex.getBindingResult().getAllErrors().forEach((error) -> {
	          String fieldName = ((FieldError) error).getField();
	          String errorMessage = error.getDefaultMessage();
	          errors.put(fieldName, errorMessage);
	      });
	      return errors;
	  }
	  
	  
	  
	  //ProductNotfoundException();
	  
	  
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  @ExceptionHandler(ProductNotfoundException.class)
	  public Map<String, String>  productnotfound(){
	     
	      Map<String, String> errors = new HashMap<String, String>();
	       
	          errors.put("message","product you are searching  is not avialble");
	       
	      return errors;
	  }
	 
}
