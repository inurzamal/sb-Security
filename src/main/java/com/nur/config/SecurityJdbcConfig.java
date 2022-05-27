package com.nur.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityJdbcConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	//Secure particular APIs only
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
		.antMatchers("/home","/contact").permitAll()
		.antMatchers("/balance").authenticated()
		.antMatchers("/statement").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/std").hasAuthority("STUDENT")
		.anyRequest().authenticated()
		
		
		.and().formLogin()
		.defaultSuccessUrl("/welcome", true)
		.and().httpBasic();
	}
	
	
	//InMemory Authentication
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select uname, upazz, uenabled from usertab where uname=?")
		.authoritiesByUsernameQuery("select uname, urole from usertab where uname=?")
		.passwordEncoder(encoder);
	}

}
