package com.ecommerce.user_service.core.entities;


import com.ecommerce.user_service.core.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;

    private String username;

    private String email;

    private String password;

    private UserRole role = UserRole.CUSTOMER;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean active;

}
