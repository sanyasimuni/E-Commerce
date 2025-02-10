package com.user.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.DTO.OrderResponse;
import com.user.DTO.ProductResponse;
import com.user.DTO.UserResponse;
import com.user.Entity.User;
import com.user.Exception.ResourceNotFoundException;
import com.user.Repo.UserRepo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public UserResponse createUser(UserResponse response) {
		
		      User user=this.mapper.map(response, User.class);
		      
		      user.setUserCode(UUID.randomUUID().toString());
		      
		     User saved= this.userRepo.save(user);
		     
		     log.info("user saved success !");
		      
		return this.mapper.map(saved, UserResponse.class);
	}

	@Override
	public UserResponse singleUser(Integer userId) {
		
		OrderResponse orderr=restTemplate.getForObject("http://localhost:8937/api/order/"+userId, OrderResponse.class);
		 ProductResponse response=restTemplate.getForObject("http://localhost:9090/api/product/"+userId, ProductResponse.class);
		 
		 User user= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Id Not Found Exception"));
		
		 UserResponse res=new UserResponse();
		 res.setOrderResponse(orderr);
		 BeanUtils.copyProperties(user, res);
		 res.setProductResponse(response);
		
		 
		
		return this.mapper.map(res, UserResponse.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		
		 User id= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Id Not Found Exception"));
			
		 this.userRepo.delete(id);
	
	}

	@Override
	public List<UserResponse> ListOfData() {
		
		   List<User>user=this.userRepo.findAll();
		   
		   List<UserResponse>userR= user.stream().map((er)->this.mapper.map(er, UserResponse.class)).collect(Collectors.toList());
		
		return userR;
	}

	@Override
	public UserResponse updateUser(UserResponse response, Integer userId) {
		
		 User id= this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Id Not Found Exception"));
			id.setAddress(response.getAddress());
			id.setPassword(response.getPassword());
			id.setPinCode(response.getPinCode());
			id.setUserCode(response.getUserCode());
			id.setUserName(response.getUserName());
			
		   User saved=this.userRepo.save(id);
			
		
		
		return this.mapper.map(saved, UserResponse.class);
	}
	
	//map The Data ModelmApper
	
	public User userTodto(UserResponse response) {
		return this.mapper.map(response, User.class);
	}
	
	public UserResponse dtoToUser(User response) {
		return this.mapper.map(response, UserResponse.class);
	}
	

}
