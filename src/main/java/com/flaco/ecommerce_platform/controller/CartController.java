package com.flaco.ecommerce_platform.controller;

import com.flaco.ecommerce_platform.dto.AddToCartRequest;
import com.flaco.ecommerce_platform.dto.CartDTO;
import com.flaco.ecommerce_platform.mapper.CartMapper;
import com.flaco.ecommerce_platform.model.Cart;
import com.flaco.ecommerce_platform.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/cart")
@PreAuthorize("hasRole('USER')")
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;

    public CartController(CartService cartService, CartMapper cartMapper) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @GetMapping
    public ResponseEntity<CartDTO> getMyCart(Principal principal) {
        return cartService.getCartDtoByUsername(principal.getName())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/items")
    public ResponseEntity<CartDTO> addItemToMyCart(Principal principal, @RequestBody AddToCartRequest request) {
        Cart updatedCart = cartService.addProductToCart(
                principal.getName(),
                request.getProductId(),
                request.getQuantity()
        );
        CartDTO cartDTO = cartMapper.toCartDTO(updatedCart);
        return ResponseEntity.ok(cartDTO);
    }
}