package com.ecommerce.product_service.core.gateway;

import com.ecommerce.product_service.core.entities.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductGateway {
    Product save(Product product);
    Optional<Product> findById(UUID id);
    boolean existsById(UUID id);
    boolean existsByName(String name);
}
