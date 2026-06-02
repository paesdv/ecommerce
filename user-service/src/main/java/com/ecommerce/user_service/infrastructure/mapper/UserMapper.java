package com.ecommerce.user_service.infrastructure.mapper;

import com.ecommerce.user_service.core.entities.User;
import com.ecommerce.user_service.infrastructure.persistance.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.isActive()
        );
    }

    public static User toDomain(UserEntity entity){
        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.isActive()
        );
    }

}
