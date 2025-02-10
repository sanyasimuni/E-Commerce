package com.product.DTO;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductResponse {


	private Integer productId;

	    @NotEmpty(message = "Name cannot be empty")
	    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
	    private String name;

	    @NotEmpty(message = "Address cannot be empty")
	    @Size(max = 255, message = "Address cannot exceed 255 characters")
	    private String address;

	    @NotEmpty(message = "Supplier name cannot be empty")
	    @Size(min = 2, max = 100, message = "Supplier name should be between 2 and 100 characters")
	    private String supliorName;
	    private LocalDateTime created;
	    
	    //private UserResponse userResponse;
	  

	    // Getters and Setters
	}

