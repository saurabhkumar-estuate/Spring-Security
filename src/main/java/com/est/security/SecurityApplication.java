package com.est.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.est.security.models.User;
import com.est.security.repo.UserRepository;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 User user = new User();
		 user.setEmail("monu@gmail.com");
		 user.setUsername("saurabh");
		 user.setPassword(this.bCryptPasswordEncoder.encode("singh"));
		 user.setRole("ROLE_NORMAL");
		 
		 this.userRepository.save(user);
		 
		 
		 
		 
		 User user1 = new User();
		 user1.setEmail("sonu@gmail.com");
		 user1.setUsername("shyam");
		 user1.setPassword(this.bCryptPasswordEncoder.encode("kumar"));
		 user1.setRole("ROLE_ADMIN");
		 
		 this.userRepository.save(user1);
		 
		
	}
	
	
	
	

}
