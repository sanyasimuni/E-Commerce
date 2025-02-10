package com.user.Service;

import java.util.List;

import com.user.DTO.UserResponse;

public interface UserService {
	
	
	public UserResponse createUser(UserResponse response);
	
	public UserResponse singleUser(Integer userId);
	
	public void deleteUser(Integer userId);
	
	public  List<UserResponse>ListOfData();
	
	public UserResponse  updateUser(UserResponse response,Integer userId);

}
