package com.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.DTO.ApiResponse;
import com.product.DTO.ProductResponse;
import com.product.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<ProductResponse> AddProduct(@Valid  @RequestBody ProductResponse
			response){
		          ProductResponse resp=this.productService.createProduct(response);
		          
		          return new ResponseEntity<>(resp,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<ProductResponse> UpdateProduct(@RequestBody ProductResponse
			response,@PathVariable Integer productId){
		          ProductResponse resp=this.productService.UpdateProduct(response, productId);
		          
		          return new ResponseEntity<>(resp,HttpStatus.OK);
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProductResponse>> ListOfProduct(){
		          List<ProductResponse> resp=this.productService.ListOfProduct();
		          
		          return new ResponseEntity<>(resp,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponse> SingleProduct(@PathVariable Integer productId){
		
		          ProductResponse resp=this.productService.singleProduct(productId);
		          
		          return new ResponseEntity<>(resp,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse>  DeleteProduct(@PathVariable Integer productId){
		
		          this.productService.DeleteProduct(productId);
		          
		          return new ResponseEntity<>(new ApiResponse("Product Delete Success !", true, "200 Ok"),HttpStatus.OK);
		
	}
	
	

}
