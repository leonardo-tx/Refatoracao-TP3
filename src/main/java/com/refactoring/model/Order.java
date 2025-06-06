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
        this.client = client;
        this.discountApplier = discountApplier;
    }

    public void addProduct(Product product) {
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
