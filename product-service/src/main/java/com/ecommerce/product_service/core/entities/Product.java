package com.ecommerce.product_service.core.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Product {

    private UUID id;

    private String title;

    private String description;

    private BigDecimal price;

    private String category;

    private String image;

    private int quantity;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
