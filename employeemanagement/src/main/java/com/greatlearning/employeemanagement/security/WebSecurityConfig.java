package com.greatlearning.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employeemanagement.service.MyUserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new MyUserDetailsService();
	}

	@Bean
	public PasswordEncoder getBCryptPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(getUserDetailsService());
		auth.setPasswordEncoder(getBCryptPasswordEncoder());
		return auth;
	}

	@Override
	public void configure(AuthenticationManagerBuilder mgr) {
		mgr.authenticationProvider(getDaoAuthenticationProvider());
	}

	@Override
	public void configure(HttpSecurity http) {
		try {

			http.httpBasic().and().authorizeRequests().antMatchers("/employees/save").hasAuthority("ADMIN")
					.antMatchers("/**").permitAll().anyRequest().authenticated().and().headers().frameOptions()
					.disable().and().cors().and().csrf().disable();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
