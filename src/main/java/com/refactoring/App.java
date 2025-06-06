package com.refactoring;

import com.refactoring.model.Client;
import com.refactoring.model.Order;
import com.refactoring.model.Product;
import com.refactoring.model.discount.DefaultDiscountApplier;
import com.refactoring.model.discount.DiscountApplier;
import com.refactoring.service.EmailService;
import com.refactoring.service.OrderService;

public class App {
    public static void main(String[] args) {
        EmailService emailService = new EmailService();
        DiscountApplier discountApplier = new DefaultDiscountApplier();
        OrderService orderService = new OrderService(emailService, discountApplier);

        Client client = new Client("joao@email.com", "João");
        Order order = orderService.createOrder(client);

        order.addProduct(new Product("Notebook", 1, 3500.0));
        order.addProduct(new Product("Mouse", 2, 80.0));

        orderService.completeTransaction(order);
    }
}
