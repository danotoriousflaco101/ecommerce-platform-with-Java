package com.flaco.ecommerce_platform.mapper;

import com.flaco.ecommerce_platform.dto.CartDTO;
import com.flaco.ecommerce_platform.dto.CartItemDTO;
import com.flaco.ecommerce_platform.model.Cart;
import com.flaco.ecommerce_platform.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.price", target = "price")
    CartItemDTO toCartItemDTO(CartItem cartItem);

    List<CartItemDTO> toCartItemDTOs(List<CartItem> cartItems);

    default CartDTO toCartDTO(Cart cart) {
        if (cart == null) {
            return null;
        }

        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(cart.getId());
        cartDTO.setItems(cart.getItems().stream().map(this::toCartItemDTO).toList());

        // Calcola il prezzo totale
        BigDecimal totalPrice = cart.getItems().stream()
                .map(item -> item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cartDTO.setTotalPrice(totalPrice);

        return cartDTO;
    }
}