package com.nur.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Secure particular APIs only
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
		.antMatchers("/balance").authenticated()
		.antMatchers("/statement").authenticated()
		.antMatchers("/home","/contact").permitAll()
		.and().formLogin()
		.and().httpBasic();
	}
	
	
	//InMemory Authentication
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("admin").authorities("admin")
		.and()
		.withUser("user").password("12345").authorities("read")
		.and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
}