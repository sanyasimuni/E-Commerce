//package com.product.Client;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.product.DTO.UserResponse;
//
//@FeignClient(name="User-MS",url = "http://localhost:8989/api/user")
//public interface ProductClient {
//	
//	@GetMapping("/{userId}")
//	public ResponseEntity<UserResponse>findByUserId(@PathVariable Integer userId);
//
//}
