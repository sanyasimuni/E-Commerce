package com.security.jwt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.jwt.Repo.UserRepo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepo  userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
  return	userRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Name Not Found Exception ..."));
		
		
	}

}
