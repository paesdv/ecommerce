package com.ecommerce.user_service.infrastructure.presentation;

import com.ecommerce.user_service.core.entities.User;
import com.ecommerce.user_service.core.usecases.LoginUseCase;
import com.ecommerce.user_service.core.usecases.RegisterUserUseCase;
import com.ecommerce.user_service.infrastructure.dto.LoginRequest;
import com.ecommerce.user_service.infrastructure.dto.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final RegisterUserUseCase registerUserUseCase;

    public AuthController(LoginUseCase loginUseCase, RegisterUserUseCase registerUserUseCase) {
        this.loginUseCase = loginUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest request) {
        User user = registerUserUseCase.execute(request.username(), request.email(), request.password());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = loginUseCase.execute(request.email(), request.password());
        return ResponseEntity.ok(token);
    }




}
