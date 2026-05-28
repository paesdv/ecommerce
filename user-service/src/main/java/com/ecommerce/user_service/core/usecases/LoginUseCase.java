package com.ecommerce.user_service.core.usecases;

import com.ecommerce.user_service.core.entities.User;
import com.ecommerce.user_service.core.gateway.PasswordEncoder;
import com.ecommerce.user_service.core.gateway.UserGateway;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginUseCase {

    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;

    public LoginUseCase(UserGateway userGateway, PasswordEncoder passwordEncoder){
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(String email, String password){
        User user = userGateway.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new InvalidPasswordException("Senha inválida.");
        }

        return jwtService.generateToken(user);
    }

}
