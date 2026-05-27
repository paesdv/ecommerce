package com.ecommerce.user_service.core.gateway;

import com.ecommerce.user_service.core.entities.User;

public interface SaveUserUseCase {
    User save(User user);
}
