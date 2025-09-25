package com.flaco.ecommerce_platform.service;

import com.flaco.ecommerce_platform.dto.CartDTO;
import com.flaco.ecommerce_platform.mapper.CartMapper;
import com.flaco.ecommerce_platform.model.*;
import com.flaco.ecommerce_platform.repository.CartRepository;
import com.flaco.ecommerce_platform.repository.ProductRepository;
import com.flaco.ecommerce_platform.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, ProductRepository productRepository,
                       UserRepository userRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.cartMapper = cartMapper;
    }

    @Transactional
    public Cart addProductToCart(String username, Long productId, int quantity) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Cart cart = cartRepository.findByUserId(user.getId()).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            return newCart;
        });

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            cart.getItems().add(newItem);
        }

        return cartRepository.save(cart);
    }

    public Optional<CartDTO> getCartDtoByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        return cartRepository.findByUserId(user.getId())
                .map(cartMapper::toCartDTO);
    }
}