package com.ecommerce.user_service.core.gateway;

import com.ecommerce.user_service.core.entities.User;

public interface FindByEmailUseCase {
    User findByEmail(String email);
}
