package com.nur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeHttpRequests()
//		.antMatchers("/balance").authenticated()
//		.antMatchers("/statement").authenticated()
//		.antMatchers("/home","/contact").permitAll()
//		.and().formLogin()
//		.and().httpBasic();
//	}
//	
//}

@Configuration
public class SecurityConfiguration{
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/balance").authenticated()
		.antMatchers("/statement").authenticated()
		.antMatchers("/home","/contact").permitAll()
		.and().formLogin()
		.and().httpBasic();
        return http.build();
    }
}
