package com.example.springbootsecurity102.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/register")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return httpSecurity.build();
        // .and()
        // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // .and()
        // .authenticationProvider(authenticationProvider())
        // .addFilterBefore(authFilter,
        // UsernamePasswordAuthenticationFilter.class).build();
    }

    // @Bean
    // UserDetailsService userDetailsService() {
    // return new UserInfoUserDetailsService();
    // }

    // @Bean
    // AuthenticationProvider authenticationProvider() {
    // DaoAuthenticationProvider authenticationProvider = new
    // DaoAuthenticationProvider();
    // authenticationProvider.setPasswordEncoder(passwordEncoder());
    // authenticationProvider.setUserDetailsService(userDetailsService());
    // return authenticationProvider();
    // }

}
