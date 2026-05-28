package com.ecommerce.user_service.core.gateway;

import com.ecommerce.user_service.core.entities.User;

public interface JwtService {
    String generateToken(User user);
}
