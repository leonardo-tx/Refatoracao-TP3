package com.refactoring.model;

import lombok.Getter;

@Getter
public final class Product {
    private final String name;
    private final int quantity;
    private final double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double calculateTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return quantity + "x " + name + " - R$" + price;
    }
}
