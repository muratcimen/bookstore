package com.muratcimen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails ahmet = User.builder()
                .username("ahmet")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mehmet = User.builder()
                .username("mehmet")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails hakan = User.builder()
                .username("murat")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ahmet, mehmet, hakan);
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configer ->
                configer
                        .requestMatchers(HttpMethod.GET, "/books/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/orders/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/users/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/orders/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/books/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/orders/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/users/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/users/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/orders/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/api/orders/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/orders/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/books/**").hasRole("EMPLOYEE")
                        .requestMatchers(toH2Console()).permitAll()
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
