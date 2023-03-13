package com.est.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.est.security.models.CustomeUserDetail;
import com.est.security.models.User;
import com.est.security.repo.UserRepository;


@Service
public class CustomUserDetailService  implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = this.userRepository.findByUsername(username);
		 if(user == null) {
			 
			 throw new UsernameNotFoundException("NO USER");
			 }
		 
		      return  new  CustomeUserDetail(user);
		
		
		
		
	}
	
	

}
