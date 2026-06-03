package com.ecommerce.user_service.core.usecases;

import com.ecommerce.user_service.core.entities.User;
import com.ecommerce.user_service.core.gateway.JwtService;
import com.ecommerce.user_service.core.gateway.PasswordEncoder;
import com.ecommerce.user_service.core.gateway.UserGateway;
import com.ecommerce.user_service.infrastructure.exception.InvalidPasswordException;
import com.ecommerce.user_service.infrastructure.exception.UserNotFoundException;

public class LoginUseCase {

    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginUseCase(UserGateway userGateway, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String execute(String email, String password){
        User user = userGateway.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new InvalidPasswordException("Senha inválida.");
        }

        return jwtService.generateToken(user);
    }

}
