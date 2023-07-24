package com.christian.tissues.tissuesbe.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSecurityConfiguration {

	//Filter chain
	//authenticate all requests
	//basic auth
	//disable csrf because app is only statless rest api
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				)
			.httpBasic(Customizer.withDefaults()).sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)
			.csrf(csrf -> csrf.disable())
			.build();
		 
	}
	
}
