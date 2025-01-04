package br.com.mariapuri.mydom.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import br.com.mariapuri.mydom.config.security.auth.AuthConfigurer;
import br.com.mariapuri.mydom.config.security.auth.AuthEntryPoint;
import br.com.mariapuri.mydom.config.security.auth.AuthTokenProvider;
import br.com.mariapuri.mydom.config.security.service.UserDetailsServiceImpl;

@Configuration
//@EnableWebSecurity /*Disable default configuration Spring Security*/
//@EnableGlobalMethodSecurity(
//    // securedEnabled = true,
//    // jsr250Enabled = true,
//    prePostEnabled = true)
public class WebSecurtiyConfig {
	
  @Autowired
  private AuthTokenProvider tokenProvider;
  
  @Autowired
  private AuthEntryPoint unauthorizedHandler;  
  
  @Autowired
  UserDetailsServiceImpl userDetailsService;
  
  
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }  
  
	@Bean
	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	}	  
  
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
		.httpBasic().and().cors().and().csrf().disable()
		//.httpBasic().and().cors().and().csrf().disable()
		//.formLogin().disable()
    
    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
    .and()
    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    
    .and()
        .authorizeRequests()
        
        //.requestMatchers("/api/auth/**").permitAll()
        
        //.requestMatchers("/api/auth/**").permitAll()
        //.requestMatchers("/persons/**").permitAll()
        //.requestMatchers("/me").permitAll()
        
        .requestMatchers("/api/auth/signin").permitAll()
        //.requestMatchers("/actuator/**").permitAll()
        //.requestMatchers("/api/v1/auth/token").permitAll()
        //.requestMatchers("/authenticate").permitAll()
        
        .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
        .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
        .requestMatchers(HttpMethod.GET).hasRole("ADMIN")        
        
        //.requestMatchers(HttpMethod.GET, "/vehicles/**").permitAll()
        //.requestMatchers(HttpMethod.DELETE, "/vehicles/**").hasRole("ADMIN")
        //.requestMatchers(HttpMethod.GET, "/v1/vehicles/**").permitAll()
        
        
    .anyRequest().authenticated()
		
    .and()
    .apply(new AuthConfigurer(tokenProvider));	
		//.apply(new AuthConfigurer(tokenProvider,authenticationProvider()));
//@formatter:on
		
		return http.build();
		
	}

}


