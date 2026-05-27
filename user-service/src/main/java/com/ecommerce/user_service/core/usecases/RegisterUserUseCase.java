package com.ecommerce.user_service.core.usecases;

import com.ecommerce.user_service.core.entities.User;
import com.ecommerce.user_service.core.enums.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegisterUserUseCase {

    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase (UserGateway userGateway, PasswordEncoder passwordEncoder){
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(String username, String email, String password){
        if(userGateway.existsByEmail(email)){
            throw new EmailAlreadyExistsException("Email já cadastrado.");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(
                UUID.randomUUID(),
                username,
                email,
                encodedPassword,
                UserRole.CUSTOMER,
                LocalDateTime.now(),
                LocalDateTime.now(),
                true
        );
        return userGateway.save(user);
    }

}
