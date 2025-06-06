package com.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static final double DISCOUNT_RATE = 0.1;

    private final Client client;
    private final List<Product> products = new ArrayList<>();

    public Order(Client client) {
        this.client = client;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printInvoice() {
        double total = 0;
        System.out.println("Cliente: " + client.getName());
        for (Product product : products) {
            System.out.println(product.getQuantity() + "x " + product.getName() + " - R$" + product.getPrice());
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + (total * DISCOUNT_RATE));
        System.out.println("Total final: R$" + (total * (1 - DISCOUNT_RATE)));
    }

    public void sendEmail() {
        EmailService.sendEmail(client.getEmail(), "Pedido recebido! Obrigado pela compra.");
    }
}
