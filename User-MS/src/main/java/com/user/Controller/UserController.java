package com.user.Controller;

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

import com.user.DTO.UserResponse;
import com.user.Exception.ApiResponse;
import com.user.Service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j

public class UserController {
	
	//private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/add")
	public ResponseEntity<UserResponse>addUser(@Valid  @RequestBody UserResponse response){
		
		           log.info("User Created Success !"+response.getUserName());
		           UserResponse creat=this.userService.createUser(response);
		           return new ResponseEntity<UserResponse>(creat,HttpStatus.CREATED);
		           
		           
		           
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<UserResponse>>ListOfGet(){
		
		    log.info("List Of Data Get Success!");
		              List<UserResponse>response=  this.userService.ListOfData();
		              return new ResponseEntity<List<UserResponse>>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse>SingleIdGet(@PathVariable Integer userId){
		
		                    log.info("User Id Deleted Success !");
		                   UserResponse resp=this.userService.singleUser(userId);
		                   return new ResponseEntity<UserResponse>(resp,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse>DeleteById(@PathVariable Integer userId){
		                   log.info("User ID Deleted Success!");
		                   this.userService.deleteUser(userId);
		                   return new ResponseEntity<>(new ApiResponse("Id Delete Success!", false),HttpStatus.OK);
		
	}
	

	@PutMapping("/update")
	public ResponseEntity<UserResponse>UpdateUser(@RequestBody UserResponse response,@PathVariable Integer userId){
		
		         log.info("User Update Success !"+response.getUserName());
		           UserResponse creat=this.userService.updateUser(response, userId);
		           
		           return new ResponseEntity<UserResponse>(creat,HttpStatus.OK);
	}
	
	

}
