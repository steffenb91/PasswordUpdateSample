package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public PasswordUpdateRestController passwordUpdateRestController(UserRepository userRepository, EmailService emailService){
        return new PasswordUpdateRestController(userRepository, emailService);
    }
}
