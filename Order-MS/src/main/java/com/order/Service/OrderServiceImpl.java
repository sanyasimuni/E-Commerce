package com.order.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.DTO.OrderResponse;
import com.order.Entity.Order;
import com.order.Repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public OrderResponse createOrder(OrderResponse orderResponse) {
		
		 Order order=this.mapper.map(orderResponse, Order.class);
		 
		 Order saved= this.orderRepo.save(order);
		 
		 
		        
		return this.mapper.map(saved, OrderResponse.class);
	}

	@Override
	public void DeleteOrder(Integer orderId) {
	
		Order order=this.orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("Id Not Found !"));
		orderRepo.delete(order);
		
	}

	@Override
	public OrderResponse singleOrder(Integer orderId) {
		// TODO Auto-generated method stub
		
		Order order=this.orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("Id Not Found !"));
		return this.mapper.map(order, OrderResponse.class);
	}
	
	///modelmapper used 
	
	public Order orderToDto(OrderResponse orderResponse) {
		return this.mapper.map(orderResponse,Order.class);
	}
	
	public OrderResponse DtoToOrder(Order orderResponse) {
		return this.mapper.map(orderResponse,OrderResponse.class);
	}

	@Override
	public List<OrderResponse> findListOfProductById(Integer productId) {
	        
		
		              List<Order>order=orderRepo.findByProductId(productId);
		              List<OrderResponse>orderResponses=order.stream().map((er)->this.mapper.map(er, OrderResponse.class)).collect(Collectors.toList());
		return orderResponses;
	}

}
