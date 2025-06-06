package com.refactoring.service;

import com.refactoring.model.Client;
import com.refactoring.model.Order;
import com.refactoring.model.OrderTotals;
import com.refactoring.model.Product;
import com.refactoring.model.discount.DiscountApplier;

public final class OrderService {
    private final EmailService emailService;
    private final DiscountApplier discountApplier;

    public OrderService(EmailService emailService, DiscountApplier discountApplier) {
        this.emailService = emailService;
        this.discountApplier = discountApplier;
    }

    public Order createOrder(Client client) {
        return new Order(client, discountApplier);
    }

    public void completeTransaction(Order order) {
        printInvoice(order);
        sendEmail(order);
    }

    private void printInvoice(Order order) {
        OrderTotals orderTotals = order.calculateOrderTotals();
        System.out.println("Cliente: " + order.getClient().getName());
        for (Product product : order) {
            System.out.println(product);
        }
        System.out.println("Subtotal: R$" + orderTotals.getTotalPrice());
        System.out.println("Desconto: R$" + orderTotals.getDiscountPrice());
        System.out.println("Total final: R$" + orderTotals.calculateFinalPrice());
    }

    private void sendEmail(Order order) {
        Client client = order.getClient();
        String email = client.getEmail();

        emailService.sendEmail(email, "Pedido recebido! Obrigado pela compra.");
    }
}
