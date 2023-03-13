package com.est.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.est.security.models.CustomeUserDetail;
import com.est.security.service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private  CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http
		          .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		          .and()
			      .authorizeRequests()
			      .antMatchers("/signin").permitAll()
			      .antMatchers("/public/**").hasRole("NORMAL")
			      .antMatchers("/users/**").hasRole("ADMIN")
			      .anyRequest()
			      .authenticated()
			      .and()
			      .formLogin()
			      .loginPage("/signin")
			      .loginProcessingUrl("/dologin")
			      .defaultSuccessUrl("/users/");
			      
		           
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
		
		//auth.inMemoryAuthentication().withUser("saurabh").password(this.passwordEncoder().encode("singh")).roles("normal");
		//auth.inMemoryAuthentication().withUser("shyam").password(this.passwordEncoder().encode("kumar")) .roles("admin");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return  new BCryptPasswordEncoder(10);
	}
	
	

	 

}
