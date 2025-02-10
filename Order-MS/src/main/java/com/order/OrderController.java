package com.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.DTO.OrderResponse;
import com.order.Service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<OrderResponse>AddOrder(@RequestBody OrderResponse response){
		                  OrderResponse orderResponse= this.orderService.createOrder(response);
		
		return new ResponseEntity<OrderResponse>(orderResponse,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponse>SingleOrder(@PathVariable Integer orderId){
		                  OrderResponse orderResponse= this.orderService.singleOrder(orderId);
		
		return new ResponseEntity<OrderResponse>(orderResponse,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?>DeleteOrder(@PathVariable Integer orderId){
		                  this.orderService.DeleteOrder(orderId);
		
		return new ResponseEntity<>("Order Id Delete Success !",HttpStatus.OK);
		
		
	}
	
	@GetMapping("/{productId}/product")
	public ResponseEntity<List<OrderResponse >>ListOfProductById(@PathVariable Integer productId){
		
		         List<OrderResponse>resp=this.orderService.findListOfProductById(productId);
		         
		return new ResponseEntity<List<OrderResponse>>(resp,HttpStatus.OK);
		
		
	}
	
	

}
