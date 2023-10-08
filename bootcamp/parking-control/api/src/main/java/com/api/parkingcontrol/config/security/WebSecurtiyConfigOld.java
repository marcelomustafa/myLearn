package com.api.parkingcontrol.config.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
//@Configuration
//@EnableWebSecurity
public class WebSecurtiyConfigOld extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                //.anyRequest().permitAll();
                .antMatchers(HttpMethod.GET,"/parking-spot/**").permitAll()
                .antMatchers(HttpMethod.POST,"/parking-spot").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/parking-spot/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*
        auth.inMemoryAuthentication()
                .withUser("michelli")
                .password(passwordEncoder().encode("607080"))
                .roles("ADIMIN");
       */

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());


    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
