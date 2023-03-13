package com.est.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/home")
	public String home()
	{
		return "this is my home page";
	}
	
	
	@GetMapping("/login")
	public String login()
	{
		return "this is my login page";
	}
	
	
	@GetMapping("/register")
	public String register()
	{
		return "this is my register page";
	}

}
