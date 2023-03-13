package com.est.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.est.security.models.User;

public interface UserRepository extends JpaRepository<User,String> {
	
	public User findByUsername(String username); 

}
