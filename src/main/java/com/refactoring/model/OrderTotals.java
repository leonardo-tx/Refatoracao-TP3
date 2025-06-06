package com.refactoring.model;

import lombok.Getter;

@Getter
public final class OrderTotals {
    private final double totalPrice;
    private final double discountPrice;

    public OrderTotals(double totalPrice, double discountPrice) {
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
    }

    public double calculateFinalPrice() {
        return totalPrice - discountPrice;
    }
}
