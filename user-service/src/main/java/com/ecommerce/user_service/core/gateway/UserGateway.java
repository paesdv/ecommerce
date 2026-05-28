package com.ecommerce.user_service.core.gateway;

import com.ecommerce.user_service.core.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserGateway {
    User save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(UUID id);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
