package com.ecommerce.user_service.core.usecases;

import com.ecommerce.user_service.core.entities.User;
import com.ecommerce.user_service.core.enums.UserRole;
import com.ecommerce.user_service.core.gateway.PasswordEncoder;
import com.ecommerce.user_service.core.gateway.UserGateway;
import com.ecommerce.user_service.infrastructure.exception.EmailAlreadyExistsException;
import com.ecommerce.user_service.infrastructure.exception.UsernameAlreadyExistsException;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegisterUserUseCase {

    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserGateway userGateway, PasswordEncoder passwordEncoder){
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(String username, String email, String password){
        if (userGateway.existsByEmail(email)){
            throw new EmailAlreadyExistsException("Email já cadastrado");
        }

        if (userGateway.existsByUsername(username)){
            throw new UsernameAlreadyExistsException("Username já cadastrado.");
        }

        User user = new User(
                null,
                username,
                email,
                passwordEncoder.encode(password),
                UserRole.CUSTOMER,
                LocalDateTime.now(),
                LocalDateTime.now(),
                true
        );

        return userGateway.save(user);

    }



}
