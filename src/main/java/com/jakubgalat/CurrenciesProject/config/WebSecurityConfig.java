// package com.jakubgalat.CurrenciesProject.config;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.context.annotation.*;
//
// @Configuration
// @EnableWebSecurity
// @ComponentScan("com.javatpoint")
// public class WebSecurityConfig {
//
//     protected void configure(HttpSecurity http) throws Exception {
//
//         http
//         .antMatcher("/")
//         .authorizeRequests()
//             .anyRequest().hasRole("ADMIN")
//             .and()
//         .httpBasic();
//     }
// }
