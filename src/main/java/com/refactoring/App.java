package com.refactoring;

public class App {
    public static void main(String[] args) {
        Client client = new Client("joao@email.com", "João");
        Order order = new Order(client);
        order.addProduct(new Product("Notebook", 1, 3500.0));
        order.addProduct(new Product("Mouse", 2, 80.0));

        order.printInvoice();
        order.sendEmail();
    }
}
