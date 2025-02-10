package com.user.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserResponse {
	
	private Integer userId;
	
	
	    @NotEmpty(message = "Username cannot be empty")
	    @Size(min = 3, max = 50, message = "Username should be between 3 and 50 characters")
	    private String userName;

	    @NotEmpty(message = "Password cannot be empty")
	    @Size(min = 8, message = "Password must be at least 8 characters long")
	    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must contain at least one letter and one number")
	    private String password;

	    @NotEmpty(message = "Address cannot be empty")
	    @Size(max = 255, message = "Address cannot exceed 255 characters")
	    private String address;

	    @NotEmpty(message = "Pin code cannot be empty")
	    @Pattern(regexp = "^[0-9]{6}$", message = "Pin code must be exactly 6 digits")
	    
	    private String pinCode;
	    
	    private String UserCode;
	    
	  
	    private ProductResponse productResponse;
	    private OrderResponse orderResponse;

	}

