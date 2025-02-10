package com.product.Service;

import java.util.List;

import com.product.DTO.ProductResponse;

public interface ProductService {
	
	public ProductResponse createProduct(ProductResponse productResponse);
	public  ProductResponse UpdateProduct(ProductResponse productResponse,Integer productId);
	
	 public ProductResponse singleProduct(Integer productId);
	
	 public void DeleteProduct(Integer ProductId);
	 
	 public List<ProductResponse> ListOfProduct();
	

}
