package com.jobmilegi.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for development only
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/signup", "/auth/user").permitAll() // Publicly accessible
                        .requestMatchers("/jobs/**").authenticated() // Requires authentication
                        .anyRequest().authenticated() // Any other request must be authenticated
                )
                .httpBasic(basic -> {}) // Enable HTTP basic authentication
                .formLogin(form -> form.disable()); // Disable form-based login (optional)

        return http.build();
    }
}
