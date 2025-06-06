package com.refactoring.model;

import com.refactoring.model.discount.DiscountApplier;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Order implements Iterable<Product> {
    @Getter
    private final Client client;
    private final DiscountApplier discountApplier;
    private final List<Product> products = new ArrayList<>();

    public Order(Client client, DiscountApplier discountApplier) {
        if (client == null) {
            throw new IllegalArgumentException("The client must not be null.");
        }
        if (discountApplier == null) {
            throw new IllegalArgumentException("The discount applier must not be null.");
        }
        this.client = client;
        this.discountApplier = discountApplier;
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("The product must not be null.");
        }
        products.add(product);
    }

    public OrderTotals calculateOrderTotals() {
        double total = 0;
        for (Product product : products) {
            total += product.calculateTotal();
        }
        double discount = discountApplier.calculateDiscount(total);
        return new OrderTotals(total, discount);
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
