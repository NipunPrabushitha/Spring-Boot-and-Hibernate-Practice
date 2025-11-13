package com.example.restCrudDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user1 = User.builder()
                .username("nipun")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();
        UserDetails user2 = User.builder()
                .username("Apeksha")
                .password("{noop}1234")
                .roles("EMPLOYEE","MANAGER")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }
}
