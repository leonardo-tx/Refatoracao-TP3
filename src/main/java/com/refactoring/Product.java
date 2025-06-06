package com.refactoring;

import lombok.Getter;

@Getter
public class Product {
    private final String name;
    private final int quantity;
    private final double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
