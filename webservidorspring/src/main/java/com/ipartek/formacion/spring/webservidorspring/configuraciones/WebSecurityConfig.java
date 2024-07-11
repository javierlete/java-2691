package com.ipartek.formacion.spring.webservidorspring.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	// https://spring.io/guides/gs/securing-web
	// https://bcrypt-generator.com/
	// https://www.baeldung.com/spring-security-jdbc-authentication
	
	// AUTENTICACIONES
	private DataSource dataSource;
	private AuthenticationManagerBuilder auth;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // NoOpPasswordEncoder.getInstance();
	
	public WebSecurityConfig(DataSource dataSource, AuthenticationManagerBuilder auth) {
		this.dataSource = dataSource;
		this.auth = auth;
	}
	
	@Autowired
	public void configureGlobal()
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource);
//	      .withUser(User.withUsername("javier")
//	        .password(passwordEncoder.encode("contrasena"))
//	        .roles("ADMIN"));
	}

	@Bean
	PasswordEncoder passwordEncoder() {
	    return passwordEncoder;
	}

	// AUTORIZACIONES
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	
// 	https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html#servlet-authentication-jdbc-schema-user
//	create table users(
//		username varchar(50) not null primary key,
//		password varchar(500) not null,
//		enabled boolean not null
//	);
//
//	create table authorities (
//		username varchar(50) not null,
//		authority varchar(50) not null,
//		constraint fk_authorities_users foreign key(username) references users(username)
//	);
//	create unique index ix_auth_username on authorities (username,authority);
}