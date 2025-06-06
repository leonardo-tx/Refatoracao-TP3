package com.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public Client client;
    public List<Product> products = new ArrayList<>();
    public double discountRate = 0.1;

    public void printInvoice() {
        double total = 0;
        System.out.println("Cliente: " + client.getName());
        for (Product product : products) {
            System.out.println(product.getQuantity() + "x " + product.getName() + " - R$" + product.getPrice());
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + (total * discountRate));
        System.out.println("Total final: R$" + (total * (1 - discountRate)));
    }

    public void sendEmail() {
        EmailService.sendEmail(client.getEmail(), "Pedido recebido! Obrigado pela compra.");
    }
}
