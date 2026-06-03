package com.ecommerce.user_service.infrastructure.beans;

import com.ecommerce.user_service.core.gateway.JwtService;
import com.ecommerce.user_service.core.gateway.PasswordEncoder;
import com.ecommerce.user_service.core.gateway.UserGateway;
import com.ecommerce.user_service.core.usecases.LoginUseCase;
import com.ecommerce.user_service.core.usecases.RegisterUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserBeans {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public RegisterUserUseCase registerUserUseCase(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        return new RegisterUserUseCase(userGateway, passwordEncoder);
    }

    @Bean
    public LoginUseCase loginUseCase(UserGateway userGateway, PasswordEncoder passwordEncoder, JwtService jwtService) {
        return new LoginUseCase(userGateway, passwordEncoder, jwtService);
    }
}