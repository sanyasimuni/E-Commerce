package com.order.DTO;

import lombok.Data;

@Data
public class OrderResponse {
	
	
	private Integer orderId;
	private Integer productId;
	private String name;
	private String location;
	private String zipCode;

}
