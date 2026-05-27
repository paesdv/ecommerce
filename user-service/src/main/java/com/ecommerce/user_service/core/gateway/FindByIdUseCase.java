package com.ecommerce.user_service.core.gateway;

import com.ecommerce.user_service.core.entities.User;

import java.util.UUID;

public interface FindByIdUseCase {
    User findById(UUID id);
}
