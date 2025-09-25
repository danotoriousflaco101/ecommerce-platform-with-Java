package com.flaco.ecommerce_platform.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data // A Lombok shortcut for @Getter, @Setter, @ToString, etc.
public class CartItemDTO {
    private Long productId;
    private String productName;
    private int quantity;
    private BigDecimal price;
}