package com.order.Service;

import java.util.List;

import com.order.DTO.OrderResponse;

public interface OrderService {
	
	public OrderResponse createOrder(OrderResponse orderResponse);
	
	void DeleteOrder(Integer orderId);
	
	public  OrderResponse singleOrder(Integer orderId);
	
	public List<OrderResponse>findListOfProductById(Integer productId);

}
