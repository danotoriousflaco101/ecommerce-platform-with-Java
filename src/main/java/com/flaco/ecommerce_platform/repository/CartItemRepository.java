package com.flaco.ecommerce_platform.repository;

import com.flaco.ecommerce_platform.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}