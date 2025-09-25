package com.flaco.ecommerce_platform.model;



import jakarta.persistence.*;

import lombok.Getter;

import lombok.Setter;



@Entity

@Table(name = "cart_items")

@Getter

@Setter

public class CartItem {

@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;



// Many-to-one relationship: many CartItems belong to one Cart

@ManyToOne(fetch = FetchType.LAZY)

@JoinColumn(name = "cart_id", nullable = false)

private Cart cart;



// Many-to-one relationship: many CartItems can refer to one Product

@ManyToOne(fetch = FetchType.LAZY)

@JoinColumn(name = "product_id", nullable = false)

private Product product;



private int quantity;

}