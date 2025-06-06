package com.refactoring.model.discount;

public final class DefaultDiscountApplier implements DiscountApplier {
    public static final double DISCOUNT_RATE = 0.1;

    @Override
    public double calculateDiscount(double price) {
        return price * DISCOUNT_RATE;
    }
}
