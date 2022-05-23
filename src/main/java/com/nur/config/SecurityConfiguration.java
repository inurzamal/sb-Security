package com.nur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


//Configuring HttpSecurity

//@Configuration
public class SecurityConfiguration{
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/balance","/statement").authenticated()
		.antMatchers("/home","/contact").permitAll()
		.and().formLogin()
		.and().httpBasic();
        return http.build();
    }
    
    //In-Memory Authentication
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("zaman")
            .password("1234")
            .roles("USER")
            .username("nur")
            .password("123")
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
