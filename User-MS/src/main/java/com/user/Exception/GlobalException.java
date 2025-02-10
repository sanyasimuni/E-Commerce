package com.user.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	
	

		
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<ApiResponse>ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
			
			
			String response=ex.getMessage();
			ApiResponse apiResponse=new ApiResponse();
			apiResponse.setMessage(response);
			apiResponse.setSuccess(true);
			
			
			return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
			
		}
		
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String,String>>MethodArgsNotFoundExceptionHandler(MethodArgumentNotValidException ex){
			
			         Map<String,String>resp=new HashMap<>();
			         ex.getBindingResult().getAllErrors().forEach((error)->{
			        	 
			        	              String filedName=((FieldError)error).getField();
			        	              String filedError=error.getDefaultMessage();
			        	 
			        	 resp.put(filedName, filedError);
			        	 
			        	 
			        	 
			         });
			 
			
			return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
			
		}
		
		
		
		
		
		
		

	}

