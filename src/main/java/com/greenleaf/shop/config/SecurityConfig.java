package com.greenleaf.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/greenleaf/about").authenticated()
                .requestMatchers("/greenleaf/contact").authenticated()
                .requestMatchers("/greenleaf/shop").authenticated()
                .requestMatchers("/greenleaf/home").permitAll()
                .requestMatchers("/greenleaf/register/**").permitAll()
                .requestMatchers("/greenleaf/login/**").permitAll()
                .requestMatchers( "/assets/css/**").permitAll());
        http.formLogin(form -> form
                .loginPage("/greenleaf/login").permitAll().defaultSuccessUrl("/greenleaf/home"));
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
       http.authenticationProvider(authenticationProvider);
        return http.build();
    }
}
