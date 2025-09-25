package com.flaco.ecommerce_platform.repository;

import com.flaco.ecommerce_platform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Per ora non servono metodi personalizzati
}