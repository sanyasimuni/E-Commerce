package com.product.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.DTO.ProductResponse;
import com.product.Entity.Product;
import com.product.Exception.ResourceNotFoundException;
import com.product.Repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	
	
	@Override
	public ProductResponse createProduct(ProductResponse productResponse) {
		
		  
		 Product create=this.mapper.map(productResponse,Product.class);
		 
		 
		 
		 create.setCreated(LocalDateTime.now());
		 
		  Product saved=this.repository.save(create);
		  
		
		return this.mapper.map(saved,ProductResponse.class);
	}

	@Override
	public ProductResponse UpdateProduct(ProductResponse productResponse, Integer productId) {
	
		 Product p=this.repository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product ID Not Found! "));
		
		 p.setAddress(productResponse.getAddress());
		 p.setName(productResponse.getName());
		 p.setSupliorName(productResponse.getSupliorName());
	
		        Product updated=this.repository.save(p);
		
		
		
		return this.mapper.map(updated, ProductResponse.class);
	}

	@Override
	public ProductResponse singleProduct(Integer productId) {
		
		 Product p=this.repository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product ID Not Found! "));
	  //   UserResponse response= restTemplate.getForObject("http://localhost:8989/api/user/"+p.getProductId(),UserResponse.class);
	     
	  //   ProductResponse resp=new ProductResponse();
	  //   resp.setUserResponse(response);
		    
		
		return this.mapper.map(p,ProductResponse.class);
	}

	

	@Override
	public List<ProductResponse> ListOfProduct() {
		
		   List<Product>produst=this.repository.findAll();
		     List<ProductResponse>resp= produst.stream().map((err)->this.mapper.map(err, ProductResponse.class)).collect(Collectors.toList());
		
		
		return resp;
	} 
	
	
	
	//modelmapper used to map the data from one To another class
	
	
	public Product productToDto(ProductResponse productResponse) {
		
		 return  this.mapper.map(productResponse, Product.class);
		
	}
	
	
	public ProductResponse DtoToResponse(Product productResponse) {
		
		 return  this.mapper.map(productResponse, ProductResponse.class);
		
	}

	@Override
	public void DeleteProduct(Integer ProductId) {
		
	 this.repository.deleteById(ProductId);
		
		
	}
	
	
	
	
	
}
