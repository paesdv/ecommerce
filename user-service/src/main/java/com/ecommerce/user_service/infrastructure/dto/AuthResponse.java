package com.ecommerce.user_service.infrastructure.dto;

import javax.management.relation.Role;

public record AuthResponse(String token, String username, String email, Role role) {
}
