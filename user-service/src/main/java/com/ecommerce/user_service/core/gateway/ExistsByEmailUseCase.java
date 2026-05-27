package com.ecommerce.user_service.core.gateway;

import com.ecommerce.user_service.core.entities.User;

public interface ExistsByEmailUseCase {
    User existsByEmail(String email);
}
