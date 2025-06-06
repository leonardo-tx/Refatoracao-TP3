package com.refactoring;

public class App {
    public static void main(String[] args) {
        Order order = new Order();
        order.client = new Client("joao@email.com", "João");
        order.products.add(new Product("Notebook", 1, 3500.0));
        order.products.add(new Product("Mouse", 2, 80.0));

        order.printInvoice();
        order.sendEmail();
    }
}
