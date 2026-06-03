package com.ecommerce.user_service.infrastructure.dto;


public record RegisterRequest(String username, String email, String password) {
}
