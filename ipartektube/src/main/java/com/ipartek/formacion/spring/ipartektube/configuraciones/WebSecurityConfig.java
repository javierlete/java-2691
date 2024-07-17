package com.ipartek.formacion.spring.ipartektube.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	// AUTENTICACIONES
	private DataSource dataSource;
	private AuthenticationManagerBuilder auth;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public WebSecurityConfig(DataSource dataSource, AuthenticationManagerBuilder auth) {
		this.dataSource = dataSource;
		this.auth = auth;
	}
	
	@Autowired
	public void configureGlobal()
	  throws Exception {
	    auth.jdbcAuthentication()
	      .passwordEncoder(passwordEncoder)
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select email,password,1 "
	        + "from usuarios "
	        + "where email = ?")
	      .authoritiesByUsernameQuery("select email,'ROLE_USER' "
	        + "from usuarios "
	        + "where email = ?");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
	    return passwordEncoder;
	}

	// AUTORIZACIONES
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(requests -> requests
				.requestMatchers("/usuarios-registrados/**").hasRole("USER")
				.anyRequest().permitAll()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout(LogoutConfigurer::permitAll);

		return http.build();
	}
	
}